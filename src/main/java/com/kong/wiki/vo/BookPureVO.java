package com.kong.wiki.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookPureVO {

    private Long id;

    private String name;

    private Long category1Id;

    private Long category2Id;

    private String description;

    private String cover;

    private Integer docCount;

    private Integer viewCount;

    private Integer voteCount;

}