package com.ning.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class IndexController {
	@RequestMapping("/regist")
	public String index() {
		return "index";
	}
}
