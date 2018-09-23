package com.ning.blog.domain;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
@Data
@ToString
public class Tips extends Common{
    private int id;
    private int userId;
    private Date creteTime;
    private Date updateTime;
    private String content;
    private int weight;
    private int commentId;
    private int like;
    private int dislike;
}
