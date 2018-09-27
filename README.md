# blog 博客
# 金蛋蛋流水水，银蛋蛋止水水。止不住，一直流。
# springboot2.0 mybatis 搭建
- 依赖
<code>

         <!-- Add typical dependencies for a web application -->
            <dependencies>
                <dependency>
                    <groupId>org.mybatis.spring.boot</groupId>
                    <artifactId>mybatis-spring-boot-starter</artifactId>
                    <version>1.3.2</version>
                </dependency>
                <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-thymeleaf</artifactId>
                </dependency>
                <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-web</artifactId>
                </dependency>
                <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-test</artifactId>
                    <!--<scope>test</scope>-->
                </dependency>
                <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-devtools</artifactId>
                    <optional>true</optional>
                </dependency>
        
                <dependency>
                    <groupId>mysql</groupId>
                    <artifactId>mysql-connector-java</artifactId>
                    <scope>runtime</scope>
                </dependency>
                <dependency>
                    <groupId>com.alibaba</groupId>
                    <artifactId>druid-spring-boot-starter</artifactId>
                    <version>1.1.9</version>
                </dependency>
                <dependency>
                    <groupId>com.google.guava</groupId>
                    <artifactId>guava</artifactId>
                    <version>18.0</version>
                </dependency>
                <dependency>
                    <groupId>commons-codec</groupId>
                    <artifactId>commons-codec</artifactId>
                    <version>1.10</version>
                </dependency>
                <dependency>
                    <groupId>org.apache.commons</groupId>
                    <artifactId>commons-lang3</artifactId>
                    <version>3.4</version>
                </dependency>
                <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
                <dependency>
                    <groupId>org.projectlombok</groupId>
                    <artifactId>lombok</artifactId>
                    <version>1.16.18</version>
                    <scope>provided</scope>
                </dependency>
                <dependency>
                    <groupId>com.getsentry.raven</groupId>
                    <artifactId>raven-logback</artifactId>
                    <version>8.0.3</version>
                </dependency>
                <!-- https://mvnrepository.com/artifact/redis.clients/jedis -->
                <dependency>
                    <groupId>redis.clients</groupId>
                    <artifactId>jedis</artifactId>
                    <version>2.9.0</version>
                </dependency>
                <dependency>
                    <groupId>commons-pool</groupId>
                    <artifactId>commons-pool</artifactId>
                    <version>1.6</version>
                </dependency>
        
                <!--  cache -->
                <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-cache</artifactId>
                </dependency>
                <!--  redis -->
                <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-data-redis</artifactId>
                </dependency>
        
            </dependencies>
        
</code>

- yml配置
<pre>server:
       port: 8080
     
     spring:
     #数据库配置
       datasource:
         name: mysql_blog
         type: com.alibaba.druid.pool.DruidDataSource
         druid:
           #监控统计拦截的filters
           filters: stat
           driver-class-name: com.mysql.jdbc.Driver
           #基本属性
           url: jdbc:mysql://139.199.122.47:3306/ning_blog?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true
           username: guotongning
           password: guotongning
     #Redis配置
       redis:
         jedis:
           pool:
             max-active: 8
         timeout: 1000
         password: guotongning
         port: 6379
         host: 139.199.122.47
         database: 0
     
     
     mybatis:
       mapper-locations: classpath:mapper/*.xml
       type-aliases-package: com.ning.blog.domain
       configuration:
         map-underscore-to-camel-case: true
         log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
