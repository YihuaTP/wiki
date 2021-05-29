package com.kong.wiki.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Category {
    private Long id;

    private Long parent;

    private String name;

    private Integer sort;


}