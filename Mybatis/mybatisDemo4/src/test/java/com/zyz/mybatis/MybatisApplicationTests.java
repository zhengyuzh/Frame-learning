package com.zyz.mybatis;

import com.zyz.mybatis.mapper.UserInfoMapper;
import com.zyz.mybatis.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisApplicationTests {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Test
    void contextLoads() {
        System.out.println(userInfoMapper.findAllUser());

    }

}
