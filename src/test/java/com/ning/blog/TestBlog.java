package com.ning.blog.test;

import com.ning.blog.BlogApplication;
import com.ning.blog.domain.User;
import com.ning.blog.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest(classes = BlogApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestBlog {
    @Autowired
    private UserService userMapper;

    @Test
    public void testDemo(){
        System.out.println("----------------------");
        List<User> users = userMapper.listUser();
        System.out.println(users);
    }
}
