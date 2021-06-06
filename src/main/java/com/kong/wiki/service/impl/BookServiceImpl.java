package com.kong.wiki.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kong.wiki.bo.BookBO;
import com.kong.wiki.bo.BookOperationBO;
import com.kong.wiki.mapper.BookMapper;
import com.kong.wiki.model.Ebook;
import com.kong.wiki.model.EbookExample;
import com.kong.wiki.service.BookService;
import com.kong.wiki.util.SnowFlake;
import com.kong.wiki.vo.BookPureVO;
import com.kong.wiki.vo.PageVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookMapper bookMapper;
    private final SnowFlake snowFlake;

    public BookServiceImpl(BookMapper bookMapper, SnowFlake snowFlake) {
        this.bookMapper = bookMapper;
        this.snowFlake = snowFlake;
    }


    /**
     * 查找电子书list，可以分页，按照名称模糊查询
     *
     * @param book
     * @return
     */
    @Override
    public PageVO<BookPureVO> getBookListByInfo(BookBO book) {
        // 组织条件对象
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria ebookExampleCriteria = ebookExample.createCriteria();

        // 如果有电子书名称信息，则根据名称信息模糊查询
        if (!(ObjectUtils.isEmpty(book.getName()))) {
            ebookExampleCriteria.andNameLike("%" + book.getName() + "%");
        }

        // 根据电子书的二级分类查询该类目下的信息
        if (!(ObjectUtils.isEmpty(book.getCategory2Id()))) {
            ebookExampleCriteria.andCategory2IdEqualTo(book.getCategory2Id());
        }

        // 判断前端是否传递分页信息，如果传递则取前端数据，如果没有则使用默认数据
        if (ObjectUtils.isEmpty(book.getPage())) {
            PageHelper.startPage(1, 100);
        } else {
            PageHelper.startPage(book.getPage(), book.getSize());
        }

        // 初始化返回集合列表
        List<BookPureVO> list = new ArrayList<>();
        List<Ebook> books = bookMapper.selectByExample(ebookExample);
        for (Ebook ebook : books) {
            BookPureVO bookPureVO = new BookPureVO();
            BeanUtils.copyProperties(ebook, bookPureVO);
            list.add(bookPureVO);
        }

        // 初始化返回的page对象
        PageInfo<Ebook> pageInfo = new PageInfo<>(books);
        long total = pageInfo.getTotal();
        PageVO<BookPureVO> pageVO = new PageVO<>();
        pageVO.setTotal(total);
        pageVO.setContent(list);

        return pageVO;
    }

    /**
     * 修改电子书信息
     *
     * @param book
     */
    @Override
    public void updateBook(BookOperationBO book) {
        Ebook ebook = new Ebook();
        BeanUtils.copyProperties(book, ebook);
        ebook.getName();
        bookMapper.updateByPrimaryKey(ebook);
    }

    /**
     * 新增电子书
     *
     * @param book
     */
    @Override
    public void insertBook(BookOperationBO book) {
        Ebook ebook = new Ebook();
        BeanUtils.copyProperties(book, ebook);
        // 新增电子书的时候，采用雪花ID作为电子书的id
        ebook.setId(snowFlake.nextId());
        ebook.setDocCount(0);
        ebook.setViewCount(0);
        ebook.setVoteCount(0);
        bookMapper.insert(ebook);
    }

    /**
     * 根据ID删除电子书信息
     *
     * @param id
     */
    @Override
    public void deleteBook(Long id) {
        // TODO 删除电子书，连带着电子书的文档也删除
        bookMapper.deleteByPrimaryKey(id);
    }
}
