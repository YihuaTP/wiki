package com.kong.wiki.bo;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookBO extends PageBO{

    private Long id;

    private String name;

    private Long category2Id;

}
