package com.kong.wiki.bo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageBO {
    private Integer page;
    private Integer size;
}
