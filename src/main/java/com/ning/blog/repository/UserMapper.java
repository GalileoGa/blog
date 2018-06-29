package com.ning.blog.repository;

import com.ning.blog.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserDO> listUser();
    UserDO getUserById(int id);
    int insertUser(UserDO user);
}
