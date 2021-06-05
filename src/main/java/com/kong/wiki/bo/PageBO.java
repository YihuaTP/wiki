package com.kong.wiki.bo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Null;

@Getter
@Setter
@ToString
public class PageBO {

    @Null(message = "【页码】不能为空")
    private Integer page;

    @Null(message = "【每页条数】不能为空")
    @Max(value = 100, message = "最多超过100条数据")
    private Integer size;
}
