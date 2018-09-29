package com.ning.blog.domain;

import lombok.*;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)//链式调用
@Data
@ToString
public class Tips extends Common {
    private int id;
    private int userId;
    private String content;
    private int weight;
    private String title;
    private int likeNum;
    private int dislikeNum;
}
