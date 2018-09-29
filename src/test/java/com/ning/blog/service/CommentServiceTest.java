package com.ning.blog.service;

import com.ning.blog.domain.Comment;
import com.ning.blog.domain.Tips;
import com.ning.blog.repository.CommentMapper;
import net.bytebuddy.asm.Advice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class CommentServiceTest {

    @Resource
    private CommentMapper commentMapper;

    @Test
    public void insertComment() {
        System.out.println("--------------------------");
        for (int i = 0; i < 10; i++) {
            Comment comment = new Comment();
            Date date = new Date();
            comment.setTipsId(3).setUserId(5).setContent("什么傻逼文章，真傻逼。").setDislikeNum(1).setCreateTime(date).setUpdateTime(date);
            int insertComment = commentMapper.insertComment(comment);
            System.out.println(insertComment == 1 ? "插入成功" : "插入失败");
            System.out.println("本次插入的评论id：" + comment.getId());
        }
    }

    @Test
    public void getCommentByTipsId() {
        System.out.println("--------------------------");
        List<Comment> commentByTipsId = commentMapper.getCommentByTipsId(3);
        commentByTipsId.forEach((comment) -> System.out.println(comment));
    }

    @Test
    public void getCommentByUserId() {
        System.out.println("--------------------------");
        List<Comment> commentByUserId = commentMapper.getCommentByUserId(5);
        commentByUserId.forEach((comment) -> System.out.println(comment));
    }

    @Test
    public void updateComment() {
        System.out.println("--------------------------");
        Comment comment = commentMapper.getCommentByTipsId(3).get(0);
        comment.setContent("测试修改其中一条评论");
        int updateComment = commentMapper.updateComment(comment);
        System.out.println(updateComment == 1 ? "修改成功" : "修改失败");
    }

    @Test
    public void deleteComment() {
        System.out.println("--------------------------");
        int deleteComment = commentMapper.deleteComment(commentMapper.getCommentByUserId(5).get(1).getId());
        System.out.println(deleteComment==1?"删除成功":"删除失败");
    }
}