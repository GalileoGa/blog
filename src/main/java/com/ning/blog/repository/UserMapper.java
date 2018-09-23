package com.ning.blog.repository;

import com.ning.blog.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> listUser();
    User getUserById(int id);
    int insertUser(User user);
}
