package com.zyz.mybatis.controller;

import com.zyz.mybatis.common.Result;
import com.zyz.mybatis.entity.UserInfo;
import com.zyz.mybatis.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @BelongsProject: Mybatis
 * @BelongsPackage: com.zyz.mybatis.controller
 * @Author: zhengyuzhu
 * @CreateTime: 2024-08-30  08:39
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userService;

    /**
     * @description: 查询所有用户 采用自己编写的sql语句
     * @author: zhengyuzhu
     * @date: 2024/8/30 9:23
     * @return: com.zyz.mybatis.common.Result
     **/
    @PostMapping("/findAllUser")
    public Result findAllUser(){
        List<UserInfo> userList = userService.findAllUser();
        return new Result(200,"成功",userList);
    }

    /**
     * @description: 查询用户信息 使用mybatis-plus 自带方法
     * @author: zhengyuzhu
     * @date: 2024/8/30 9:26
     * @return: com.zyz.mybatis.common.Result
     **/
    @PostMapping("/getOneUser")
    public Result getOneUser(Integer id){
        UserInfo userInfo = userService.getOneUser(id);
        return new Result(200,userInfo);
    }


}
