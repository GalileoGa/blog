package com.ning.blog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

	private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

	@GetMapping("/comment/putcomment")
	public String commitComment() {
		return "成功！";
	}
}
