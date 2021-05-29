package com.kong.wiki.controller;

import com.kong.wiki.bo.BookBO;
import com.kong.wiki.model.Ebook;
import com.kong.wiki.service.BookService;
import com.kong.wiki.core.UnifyResponse;
import com.kong.wiki.vo.BookVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * 查询所有的电子书
     *
     * @return
     */
    @GetMapping("/list")
    public UnifyResponse<List<BookVO>> getBookList() {
        UnifyResponse<List<BookVO>> us = new UnifyResponse<>();
        List<BookVO> books = bookService.getBookList();
        us.setContent(books);
        return us;
    }

    /**
     * 根据名称查模糊询电子书
     *
     * @param name
     * @return
     */
    @GetMapping("/{name}")
    public UnifyResponse<List<BookVO>> getBookListByName(@PathVariable String name) {
        UnifyResponse<List<BookVO>> us = new UnifyResponse<>();
        List<BookVO> books = bookService.getBookListByName(name);
        us.setContent(books);
        return us;
    }

    /**
     * 根据电子书信息查询对应的电子书
     *
     * @param book
     * @return
     */
    @GetMapping("/info")
    public UnifyResponse<List<BookVO>> getBookByInfo(@RequestBody BookBO book) {
        UnifyResponse<List<BookVO>> us = new UnifyResponse<>();
        List<BookVO> books = bookService.getBookListByInfo(book);
        us.setContent(books);
        return us;
    }

}
