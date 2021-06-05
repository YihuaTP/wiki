package com.kong.wiki.service;

import com.kong.wiki.bo.BookBO;
import com.kong.wiki.bo.BookOperationBO;
import com.kong.wiki.vo.BookPureVO;
import com.kong.wiki.vo.PageVO;

public interface BookService {

    // 查找电子书list，可以分页，按照名称模糊查询
    PageVO<BookPureVO> getBookListByInfo(BookBO book);

    // 修改电子书信息
    void updateBook(BookOperationBO book);

    // 新增电子书
    void insertBook(BookOperationBO book);

    // 根据ID删除电子书
    void deleteBook(Long id);



}
