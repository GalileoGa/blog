# blog 博客
# 种一棵树最好的时间是十年前,其次是现在
# springboot2.0 mybatis 搭建
- 依赖
<code>

        <!-- springboot 集成 mybatis>
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>1.3.2</version>
        </dependency>
        
        <!-- restapi -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        
        <!-- 单元测试 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        
        <!-- jdbc驱动 -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
        
        <!-- 热部署 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <optional>true</optional>
        </dependency>

        <!-- alibaba的druid数据库连接池 -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid-spring-boot-starter</artifactId>
            <version>1.1.9</version>
        </dependency>
        
</code>

- yml配置
<pre>spring:
  datasource:
    name: mysql_blog
    type: com.alibaba.druid.pool.DruidDataSource
    druid:
      #监控统计拦截的filters
      filters: stat
      driver-class-name: com.mysql.jdbc.Driver
      #基本属性
      url: jdbc:mysql://127.0.0.1:3306/blog?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true
      username: root
      password: root

mybatis:
  mapper-locations: classpath:mapper/*.xml
  type-aliases-package: com.ning.blog.domain
  configuration:
    map-underscore-to-camel-case: true
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl</pre>
- 注解<br>
@Mapper