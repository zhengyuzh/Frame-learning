package com.zyz.springdataredisdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringDataRedisDemoApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    void testString(){
        //写入一条String数据
        redisTemplate.opsForValue().set("name","张三");

        //获取string数据
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println("name:" + name);
        /**
         *
         * 测试结果
         *
         * name:张三
         **/
    }

    @Test
    void contextLoads() {
    }

}
