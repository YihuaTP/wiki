package com.kong.wiki.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试controller
 */
@RestController
@RequestMapping(value = "/demo")
public class DemoController {

    @GetMapping(value = "/get")
    public String getDemo() {
        return "getDemo";
    }
}
