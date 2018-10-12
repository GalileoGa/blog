package com.ning.blog.repository;

import com.ning.blog.domain.Tips;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TipsMapper {
    List<Tips> getTipsByUserId(int userId);
    Tips getTipsById(int id);
    int insertTips(Tips tips);
    int deleteTips(int id);
    int updateTips(Tips tips);
}
