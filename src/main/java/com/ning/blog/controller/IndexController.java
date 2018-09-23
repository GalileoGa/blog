package com.ning.blog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);


    @GetMapping("/test")
    public String index(Model model) {
        logger.info("进入身体");
        model.addAttribute("username", "fuck");
        return "/index";
    }

    @GetMapping("/login")
    public String signIn() {
        return "/login";
    }
}
