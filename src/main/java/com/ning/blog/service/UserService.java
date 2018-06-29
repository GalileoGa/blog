package com.ning.blog.service;

import com.ning.blog.domain.UserDO;
import com.ning.blog.repository.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public List<UserDO> listUser() {
        return userMapper.listUser();
    }
}
