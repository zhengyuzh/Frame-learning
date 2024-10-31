package com.zyz.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// @MapperScan("com.zyz.mybatis.mapper")
// @MapperScan({"com.zyz.mybatis.mapper", "com.zyz.mybatis.system.userManage.mapper"})
@MapperScan("com.zyz.mybatis.**.mapper")
@SpringBootApplication
public class MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }

}
