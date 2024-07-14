package com.zyz.springdataredisdemo;

import com.zyz.springdataredisdemo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;


@SpringBootTest
class SpringDataRedisDemoApplicationTests {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;


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

    /**
     * @description: 存储序列化话对象
     * @author: zhengyuzhu
     * @date: 2024/7/13 21:51
     **/
    @Test
    void testObject(){
        //设置数据
        redisTemplate.opsForValue().set("user:1",new User("张三",18));

        //获取string数据
        User user = (User) redisTemplate.opsForValue().get("user:1");
        System.out.println("user:" + user);
        /**
         *
         * 测试结果
         *
         * user:User(name=张三, age=18)
         **/
    }


    @Test
    void contextLoads() {
    }

}
