package com.ning.blog.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)//链式调用
public class User extends Common {
    private int id;
    private String userName;
    private String loginName;
    private String password;
    private String salt;
    private int weight;
}
