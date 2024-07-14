package com.zyz.springdataredisdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zyz.springdataredisdemo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;


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

    

}
