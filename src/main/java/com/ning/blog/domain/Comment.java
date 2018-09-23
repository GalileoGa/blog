package com.ning.blog.domain;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Comment extends Common{
    private int id;
    private int userId;
    private String content;
    private Date createTime;
    private Date updateTime;
    private int like;
    private int dislike;
}
