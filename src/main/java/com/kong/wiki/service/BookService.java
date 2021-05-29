package com.kong.wiki.service;

import com.kong.wiki.bo.BookBO;
import com.kong.wiki.model.Ebook;
import com.kong.wiki.vo.BookVO;

import java.util.List;

public interface BookService {

    // 查询所有的电子书
    List<BookVO> getBookList();

    // 根据名称模糊查询电子书
    List<BookVO> getBookListByName(String name);

    // 根据电子书信息查询对应的电子书
    List<BookVO> getBookListByInfo(BookBO book);



}
