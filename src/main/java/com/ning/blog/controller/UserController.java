package com.ning.blog.controller;

import com.ning.blog.domain.UserDO;
import com.ning.blog.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/register")
    public String signUp() {
        return "register";
    }

    @PostMapping("/login")
    public String login(UserDO userDO) {
        if(userDO != null) {
            return "/index";
        }
        return "/index";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/url")
    @ResponseBody
    public String getUrl() {
        return "https://github.com/GalileoGa/blog.git";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<UserDO> listUser() {
        return userService.listUser();
    }

    @GetMapping("/{id}")
    public UserDO getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/save")
    public String saveUser(UserDO user) {
        return userService.saveUser(user) == 1 ? "成功！" : "失败";
    }
}
