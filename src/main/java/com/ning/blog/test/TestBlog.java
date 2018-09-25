package com.ning.blog.test;


import com.ning.blog.utils.RedisClient;
import redis.clients.jedis.Jedis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestBlog {
    public static void main(String[] args) throws Exception {
        //测试数据库连接
//        testJdbcConnection();
        TestRedis();
    }

    private static void TestRedis() {
        Jedis jedis = RedisClient.getJedis();
        String question = "郭桐宁是谁?";
        jedis.set(question, answer);
        System.out.println(jedis.get(question));
    }

    private static void testJdbcConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://139.199.122.47:3306/ning_blog?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true";
        String user = "guotongning";
        String password = "guotongning";
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }



































































    private static String answer = "郭桐宁是任天辙的爸爸！";
}
