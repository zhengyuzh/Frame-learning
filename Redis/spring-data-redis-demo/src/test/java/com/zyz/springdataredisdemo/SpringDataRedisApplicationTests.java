package com.zyz.springdataredisdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zyz.springdataredisdemo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Map;


@SpringBootTest
class SpringDataRedisApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //JSON工具
    private static final ObjectMapper mapper = new ObjectMapper();

    @Test
    void testStringTemplate() throws JsonProcessingException{
        //准备对象
        User user = new User("张三",18);

        //手动序列化
        String json = mapper.writeValueAsString(user);
        //写入一条数据到redis
        stringRedisTemplate.opsForValue().set("user:2",json);

        //读取数据
        String val = stringRedisTemplate.opsForValue().get("user:2");
        //反序列化
        User user1 = mapper.readValue(val,User.class);
        System.out.println("user1 = " + user1);
    }

    /**
     *
     * 测试结果
     *
     * user1 = User(name=张三, age=18)
     **/

    /**
     * @description: 测试Hash
     * @author: zhengyuzhu
     * @date: 2024/7/14 17:16
     **/
    @Test
    void testHash(){
        stringRedisTemplate.opsForHash().put("user:3","name","张三");
        stringRedisTemplate.opsForHash().put("user:3","age","18");

        Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries("user:3");
        System.out.println("entries = " + entries);
        /**
         *
         * 测试结果
         *
         * entries = {name=张三, age=18}
         **/


    }

}
