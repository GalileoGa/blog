package com.ning.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
	@GetMapping("/comment/putcomment")
	public String commitComment() {
		
		return "成功！";
	}
}
