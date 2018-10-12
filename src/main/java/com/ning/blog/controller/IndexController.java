package com.ning.blog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/share")
    public String share() {
        return "share";
    }

    @RequestMapping("/list")
    public String list() {
        return "list";
    }

    @RequestMapping("/life")
    public String life() {
        return "life";
    }

    @RequestMapping("/time")
    public String time() {
        return "time";
    }

    @RequestMapping("/gbook")
    public String gbook() {
        return "gbook";
    }

    @RequestMapping("/info")
    public String info() {
        return "info";
    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("top")
    public String top() {
        return "top";
    }

    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping("regist")
    public String regist() {
        return "regist";
    }

}
