package com.ning.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {
    @GetMapping("/test")
    public String index(Model model) {
        model.addAttribute("username", "fuck");
        return "/index";
    }

    @GetMapping("/login")
    public String signIn() {
        return "/login";
    }
}
