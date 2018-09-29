package com.ning.blog;

import com.ning.blog.controller.CommentController;
import com.ning.blog.domain.Tips;
import com.ning.blog.domain.User;
import com.ning.blog.service.TipsService;
import com.ning.blog.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = BlogApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestBlog {

    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private UserService userService;

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    //Redis 添加删除key
    @Test
    public void testRedis() {
        System.out.println("----------------------");
        redisTemplate.opsForValue().append("进入身体", "水乱流");
        System.out.println("是否包含 key'进入身体'" + redisTemplate.hasKey("进入身体"));
        System.out.println("\t任天辙被进入身体后会？\r\n\t答案：" + redisTemplate.opsForValue().get("进入身体"));
        String result = redisTemplate.delete("进入身体") == true ? "成功止水" : "水继续乱流";
        System.out.println("尝试止水\r\n止水中。。。\r\n" + result);
    }

    //logger日志打印
    @Test
    public void tsetLogger() {
        List<User> users = userService.listUser();
        String phone = "17601010135";
        String code = "123456 ";
        //这种写法回把集合填进去感觉没什么用
        logger.info("查询出的User集合：{}", users);
        //这种写法就不用再拼字符串了。按照花括号顺序把后面的参数挨个填进去
        logger.info("手机号：{} 验证码：{}", phone, code);
    }

}