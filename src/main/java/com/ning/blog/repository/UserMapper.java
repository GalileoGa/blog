package com.ning.blog.repository;

import com.ning.blog.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    List<User> listUser();

    User getUserByParam(Map<String, Object> param);

    User getUserById(int id);

    int insertUser(User user);

    int updateUser(User user);
}
