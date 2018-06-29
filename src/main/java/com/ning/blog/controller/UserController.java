package com.ning.blog.controller;

import com.ning.blog.domain.UserDO;
import com.ning.blog.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/index")
    public String index(){
        return "hello world";
    }

    @GetMapping("/url")
    public String getUrl() {
        return "https://github.com/GalileoGa/blog.git";
    }

    @GetMapping("/list/user")
    public List<UserDO> listUser() {
        return userService.listUser();
    }
}
