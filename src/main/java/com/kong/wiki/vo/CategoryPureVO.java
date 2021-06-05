package com.kong.wiki.vo;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryPureVO {

    private Long id;

    private Long parent;

    private String name;

    private Integer sort;

}