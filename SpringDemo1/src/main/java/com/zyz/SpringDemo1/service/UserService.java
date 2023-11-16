package com.zyz.SpringDemo1.service;

import com.zyz.SpringDemo1.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/11/15 22:50
 * @Description:  在注解里面 value 属性值可以省略不写
 *                默认值是类名称，首字母小写
 *                UserService -- userService
 */

@Service
public class UserService {
    /**
     *     定义 dao 类型属性
     *     不需要添加 set 方法
     *     添加注入属性注解
     */
    @Autowired  //根据类型自动装配
    @Qualifier("userDaoImplTwo")  //根据起的名称
    private UserDao userDao;

    public void say(){
        userDao.showTime();
        System.out.println("UserService say .......");
    }

}