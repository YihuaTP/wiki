package com.kong.wiki.controller;

import com.kong.wiki.model.Ebook;
import com.kong.wiki.service.BookService;
import com.kong.wiki.vo.UnifyResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    public UnifyResponse<List<Ebook>> getBookList() {
        UnifyResponse<List<Ebook>> books = new UnifyResponse<>();
        books.setContent(bookService.getBookList());
        return books;
    }
}
