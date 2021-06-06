package com.kong.wiki.service;

import com.kong.wiki.bo.DocQueryReq;
import com.kong.wiki.bo.DocSaveReq;
import com.kong.wiki.vo.DocQueryResp;
import com.kong.wiki.vo.PageVO;

import java.util.List;

public interface DocService {

    List<DocQueryResp> all(Long ebookId);

    PageVO<DocQueryResp> list(DocQueryReq req);

    void save(DocSaveReq req);

    void delete(Long id);

    String findContent(Long id);

    void vote(Long id);
}
