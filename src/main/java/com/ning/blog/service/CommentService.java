package com.ning.blog.service;

import com.ning.blog.domain.Comment;
import com.ning.blog.repository.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用途：
 * 作者：郭桐宁
 * 时间：2018/9/29 15:46
 * Version:1.0
 */
@Service
public class CommentService {

    @Resource
    private CommentMapper commentMapper;

    public List<Comment> getCommentByTipsId(int tipsId) {
        return commentMapper.getCommentByTipsId(tipsId);
    }

    public List<Comment> getCommentByUserId(int userId) {
        return commentMapper.getCommentByTipsId(userId);
    }

    public int insertComment(Comment comment) {
        return commentMapper.insertComment(comment);
    }

    public int updateComment(Comment comment) {
        return commentMapper.updateComment(comment);
    }

    public int deleteComment(int id) {
        return commentMapper.deleteComment(id);
    }

}
