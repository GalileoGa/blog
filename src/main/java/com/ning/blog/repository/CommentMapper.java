package com.ning.blog.repository;

import com.ning.blog.domain.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    List<Comment> getCommentByTipsId(int tipsId);

    List<Comment> getCommentByUserId(int userId);

    int insertComment(Comment comment);

    int updateComment(Comment comment);

    int deleteComment(int id);
}
