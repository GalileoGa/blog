package com.ning.blog.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class Comment extends Common {
    private int id;
    private int userId;
    private String content;
    private Date createTime;
    private Date updateTime;
    private int like;
    private int dislike;
}
