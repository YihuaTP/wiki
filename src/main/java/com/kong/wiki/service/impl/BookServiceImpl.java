package com.kong.wiki.service.impl;

import com.kong.wiki.bo.BookBO;
import com.kong.wiki.mapper.BookMapper;
import com.kong.wiki.model.Ebook;
import com.kong.wiki.model.EbookExample;
import com.kong.wiki.service.BookService;
import com.kong.wiki.vo.BookVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookMapper bookMapper;

    public BookServiceImpl(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    /**
     * 查询所有的电子书
     *
     * @return
     */
    @Override
    public List<BookVO> getBookList() {
        List<BookVO> list = new ArrayList<>();
        List<Ebook> books = bookMapper.selectByExample(null);
        for (Ebook book : books) {
            BookVO bookVO = new BookVO();
            BeanUtils.copyProperties(book, bookVO);
            list.add(bookVO);
        }
        return list;
    }

    /**
     * 根据名称模糊查询电子书
     *
     * @param name
     * @return
     */
    @Override
    public List<BookVO> getBookListByName(String name) {
        List<BookVO> list = new ArrayList<>();
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria ebookExampleCriteria = ebookExample.createCriteria();
        ebookExampleCriteria.andNameLike("%" + name + "%");
        List<Ebook> books = bookMapper.selectByExample(ebookExample);
        for (Ebook book : books) {
            BookVO bookVO = new BookVO();
            BeanUtils.copyProperties(book, bookVO);
            list.add(bookVO);
        }
        return list;
    }

    /**
     * 根据电子书信息查询应用的电子书
     *
     * @param book
     * @return
     */
    @Override
    public List<BookVO> getBookListByInfo(BookBO book) {
        List<BookVO> list = new ArrayList<>();
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria ebookExampleCriteria = ebookExample.createCriteria();
        ebookExampleCriteria.andNameLike("%" + book.getName() + "%");
        ebookExampleCriteria.andIdEqualTo(book.getId());
        List<Ebook> books = bookMapper.selectByExample(ebookExample);
        for (Ebook ebook : books) {
            BookVO bookVO = new BookVO();
            BeanUtils.copyProperties(ebook, bookVO);
            list.add(bookVO);
        }
        return list;
    }
}
