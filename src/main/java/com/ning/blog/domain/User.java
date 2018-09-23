package com.ning.blog.domain;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class User extends Common{
    private int id;
    private String userName;
    private String loginName;
    private String password;
    private Date createTime;
    private Date updateTime;
    private Date brithday;
    private String salt;
    private int weight;
}
