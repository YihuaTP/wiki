package com.kong.wiki.mapper;

import com.kong.wiki.model.Ebook;
import com.kong.wiki.model.EbookExample;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMapper {

    List<Ebook> selectByExample(EbookExample example);

}
