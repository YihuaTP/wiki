package com.kong.wiki.controller;

import com.kong.wiki.bo.BookBO;
import com.kong.wiki.core.UnifyResponse;
import com.kong.wiki.service.BookService;
import com.kong.wiki.vo.BookVO;
import com.kong.wiki.vo.PageVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public UnifyResponse<PageVO<BookVO>> getBookByInfo(BookBO book) {
        UnifyResponse<PageVO<BookVO>> us = new UnifyResponse<>();
        PageVO<BookVO> books = bookService.getBookListByInfo(book);
        us.setContent(books);
        return us;
    }

}
