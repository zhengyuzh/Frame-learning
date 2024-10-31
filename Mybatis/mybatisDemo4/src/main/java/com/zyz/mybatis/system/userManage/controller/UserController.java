package com.zyz.mybatis.system.userManage.controller;

import com.zyz.mybatis.common.Result;
import com.zyz.mybatis.system.userManage.entity.User;
import com.zyz.mybatis.system.userManage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @BelongsProject: Mybatis
 * @BelongsPackage: com.zyz.mybatis.system.userManage.controller
 * @Author: zhengyuzhu
 * @CreateTime: 2024-10-31  11:02
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getAllUser")
    public Result getUserList(){
        List<User> userList = userService.getUserList();
        return new Result(00,"成功",userList);
    }
}
