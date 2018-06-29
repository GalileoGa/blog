package com.ning.blog.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ning.blog.domain.UserDO;
import com.ning.blog.service.UserService;

@RestController
public class UserController {

	@Resource
	private UserService userService;

	@GetMapping("/index")
	public String index() {
		return "hello world";
	}

	@GetMapping("/url")
	public String getUrl() {
		return "https://github.com/GalileoGa/blog.git";
	}

	@GetMapping("/user/list")
	public List<UserDO> listUser() {
		return userService.listUser();
	}

	@GetMapping("/user/{id}")
	public UserDO getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}

	@PostMapping("/user/save")
	public String saveUser(UserDO user) {
		return "成功！！！";
	}
}
