package com.ning.blog.service;

import com.ning.blog.domain.User;
import com.ning.blog.repository.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class UserServiceTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void listUser() {
        System.out.println("----------------------");
        List<User> users = userMapper.listUser();
        users.forEach((user -> System.out.println(user)));
    }

    @Test
    public void getUserById() {
        System.out.println("----------------------");
        User userById = userMapper.getUserById(5);
        System.out.println(userById);
    }

    @Test
    public void saveUser() {
        System.out.println("----------------------");
        Date date = new Date();
        User user = new User();
        user.setLoginName("rentianzhe").setPassword("rentianzhe").setSalt("ERIUGYOAEIFHDLASDFRG")
                .setUserName("任天辙").setWeight(9999999).setCreateTime(date).setUpdateTime(date);
        String result = userMapper.insertUser(user) == 1 ? "成功" : "失败";
        System.out.println("插入" + result + ",插入的用户id：" + user.getId());
    }

    @Test
    public void updateUser() {
        System.out.println("----------------------");
        User user = userMapper.getUserById(3);
        user.setUserName("尼古拉斯_宁");
        int result = userMapper.updateUser(user);
        System.out.println(result == 1 ? "update success" : "update failure");
    }
}