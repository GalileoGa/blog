package com.ning.blog.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class User extends Common {
    private int id;
    private String userName;
    private String loginName;
    private String password;
    private String salt;
    private int weight;
}
