package com.kong.wiki.vo;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageVO<T> {

    private Long total;

    private List<T> content;

}
