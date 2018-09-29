package com.ning.blog.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)//链式调用
public class Comment extends Common {
    private int id;
    private int userId;
    private int tipsId;
    private String content;
    private int likeNum;
    private int dislikeNum;
}
