package com.ning.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/index")
    public String index(){
        return "hello world";
    }

    @GetMapping("/url")
    public String getUrl() {
        return "https://github.com/GalileoGa/blog.git";
    }
}
