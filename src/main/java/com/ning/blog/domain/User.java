package com.ning.blog.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class User extends Common {
    private int id;
    private String userName;
    private String loginName;
    private String password;
    private Date createTime;
    private Date updateTime;
    private Date birthday;
    private String salt;
    private int weight;
}
