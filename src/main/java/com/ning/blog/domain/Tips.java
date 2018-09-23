package com.ning.blog.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class Tips extends Common {
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
