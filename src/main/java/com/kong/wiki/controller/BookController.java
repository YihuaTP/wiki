package com.kong.wiki.controller;

import com.kong.wiki.bo.BookBO;
import com.kong.wiki.bo.BookOperationBO;
import com.kong.wiki.core.UnifyResponse;
import com.kong.wiki.service.BookService;
import com.kong.wiki.vo.BookPureVO;
import com.kong.wiki.vo.PageVO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * 查找电子书list，可以分页，按照名称模糊查询
     *
     * @param book
     * @return
     */
    @GetMapping("/info")
    public UnifyResponse<PageVO<BookPureVO>> getBookByInfo(BookBO book) {
        UnifyResponse<PageVO<BookPureVO>> us = new UnifyResponse<>();
        PageVO<BookPureVO> books = bookService.getBookListByInfo(book);
        us.setContent(books);
        return us;
    }

    /**
     * 修改电子书信息
     *
     * @param operationBO
     * @return
     */
    @PutMapping("/edit")
    public UnifyResponse updateBook(@RequestBody BookOperationBO operationBO) {
        bookService.updateBook(operationBO);
        return new UnifyResponse();
    }

    /**
     * 新增电子书
     *
     * @param operationBO
     * @return
     */
    @PostMapping("/add")
    public UnifyResponse addBook(@RequestBody BookOperationBO operationBO) {
        bookService.insertBook(operationBO);
        return new UnifyResponse();
    }

    /**
     * 删除电子书信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/remove/{id}")
    public UnifyResponse deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return new UnifyResponse();
    }

}
