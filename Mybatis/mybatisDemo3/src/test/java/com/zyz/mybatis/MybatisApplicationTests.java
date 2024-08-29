package com.zyz.mybatis;

import com.zyz.mybatis.entity.User;
import com.zyz.mybatis.mapper.UserMapper;
import com.zyz.mybatis.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        System.out.println(userMapper.selectByPrimaryKey(1));
    }

    @Test
    void queryUser(){
        User user = userService.selectByPrimaryKey(1);
        System.out.println(user.toString());
    }



}
