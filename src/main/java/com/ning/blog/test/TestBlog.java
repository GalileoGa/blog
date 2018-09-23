package com.ning.blog.test;

import com.ning.blog.domain.User;

import java.util.Date;

public class TestBlog {
    public static void main(String[] args) {
        User user = new User();
        System.out.println(user.getDateStrL(new Date()));
        System.out.println(user.getDateStrS(new Date()));
    }
}
