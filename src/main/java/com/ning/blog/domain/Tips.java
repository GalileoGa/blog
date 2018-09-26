package com.ning.blog.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Tips extends Common {
    private int id;
    private int userId;
    private String content;
    private int weight;
    private int commentId;
    private int like;
    private int dislike;
}
