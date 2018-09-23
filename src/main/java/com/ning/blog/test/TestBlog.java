package com.ning.blog.test;


import redis.clients.jedis.Jedis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestBlog {
    public static void main(String[] args) throws Exception {
        //测试数据库连接
//        testJdbcConnection();
        Jedis jedis = new Jedis("10.80.248.24");
        System.out.println(jedis.ping());
    }

    private static void testJdbcConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://139.199.122.47:3306/ning_blog?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true";
        String user = "guotongning";
        String password = "guotongning";
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }
}
