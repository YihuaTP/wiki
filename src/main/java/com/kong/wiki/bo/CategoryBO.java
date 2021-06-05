package com.kong.wiki.bo;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryBO {

    private Long id;

    private Long parent;

    private String name;

    private Integer sort;

}