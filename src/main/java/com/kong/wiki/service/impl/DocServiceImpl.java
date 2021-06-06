package com.kong.wiki.service.impl;

import com.kong.wiki.bo.DocQueryReq;
import com.kong.wiki.bo.DocSaveReq;
import com.kong.wiki.service.DocService;
import com.kong.wiki.vo.DocQueryResp;
import com.kong.wiki.vo.PageVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocServiceImpl implements DocService {
    @Override
    public List<DocQueryResp> all(Long ebookId) {
        return null;
    }

    @Override
    public PageVO<DocQueryResp> list(DocQueryReq req) {
        return null;
    }

    @Override
    public void save(DocSaveReq req) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public String findContent(Long id) {
        return null;
    }

    @Override
    public void vote(Long id) {

    }
}
