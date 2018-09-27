package com.ning.blog;

import com.ning.blog.domain.User;
import com.ning.blog.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@SpringBootTest(classes = BlogApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestBlog {
    @Autowired
    private UserService userService;

    @Test
    public void testDemo() {
        System.out.println("----------------------");
        List<User> users = userService.listUser();
        System.out.println(users);

    }

    @Test
    public void testUpdateUser() {
        System.out.println("----------------------");
        User user = userService.getUserById(3);
        user.setUserName("尼古拉斯_宁");
        int result = userService.updateUser(user);
        System.out.println(result == 1 ? "update success" : "update failure");
    }

    @Test
    public void testInsertUser() {
        System.out.println("----------------------");
        Date date = new Date();
        User user = new User();
        user.setLoginName("rentianzhe");
        user.setPassword("rentianzhe");
        user.setCreateTime(date);
        user.setSalt("ERIUGYOAEIFHDLASDFRG");
        user.setUpdateTime(date);
        user.setUserName("任天辙");
        user.setWeight(9999999);
        String result = userService.saveUser(user) == 1 ? "成功" : "失败";
        System.out.println("插入" + result + ",插入的用户id：" + user.getId());
    }

    @Test
    public void testGetUserList() {
        System.out.println("----------------------");
        List<User> users = userService.get();
        System.out.println(users);
    }
}