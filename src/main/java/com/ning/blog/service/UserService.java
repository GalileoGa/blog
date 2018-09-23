package com.ning.blog.service;

import com.ning.blog.domain.User;
import com.ning.blog.repository.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public List<User> listUser() {
        return userMapper.listUser();
    }

    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    public int saveUser(User user) {
        return userMapper.insertUser(user);
    }
}
