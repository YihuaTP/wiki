package com.kong.wiki.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kong.wiki.bo.BookBO;
import com.kong.wiki.mapper.BookMapper;
import com.kong.wiki.model.Ebook;
import com.kong.wiki.model.EbookExample;
import com.kong.wiki.service.BookService;
import com.kong.wiki.vo.BookVO;
import com.kong.wiki.vo.PageVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookMapper bookMapper;

    public BookServiceImpl(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    /**
     * 查找电子书list，可以分页，按照名称模糊查询
     *
     * @param book
     * @return
     */
    @Override
    public PageVO<BookVO> getBookListByInfo(BookBO book) {
        // 组织条件对象
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria ebookExampleCriteria = ebookExample.createCriteria();
        // 如果有电子书名称信息，则根据名称信息模糊查询
        if (!(ObjectUtils.isEmpty(book.getName()))) {
            // 按照名称模糊查询
            ebookExampleCriteria.andNameLike("%" + book.getName() + "%");
        }
        if (ObjectUtils.isEmpty(book.getPage())) {
            // 前端没有传参数，默认查询所有的电子书
            PageHelper.startPage(1, 100);
        } else {
            // 进行分页查询配置
            PageHelper.startPage(book.getPage(), book.getSize());
        }
        // 初始化返回集合列表
        List<BookVO> list = new ArrayList<>();
        List<Ebook> books = bookMapper.selectByExample(ebookExample);
        for (Ebook ebook : books) {
            BookVO bookVO = new BookVO();
            BeanUtils.copyProperties(ebook, bookVO);
            list.add(bookVO);
        }
        // 初始化返回的page对象
        PageInfo<Ebook> pageInfo = new PageInfo<>(books);
        long total = pageInfo.getTotal();
        PageVO<BookVO> pageVO = new PageVO<>();
        pageVO.setTotal(total);
        pageVO.setContent(list);

        return pageVO;
    }
}
