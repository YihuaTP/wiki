package com.kong.wiki.service;

import com.kong.wiki.bo.BookBO;
import com.kong.wiki.vo.BookVO;
import com.kong.wiki.vo.PageVO;

public interface BookService {

    // 查找电子书list，可以分页，按照名称模糊查询
    PageVO<BookVO> getBookListByInfo(BookBO book);



}
