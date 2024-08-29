package com.zyz.mybatis.controller;

import com.zyz.mybatis.common.Result;
import com.zyz.mybatis.entity.User;
import com.zyz.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;

/**
 * @BelongsProject: Mybatis
 * @BelongsPackage: com.zyz.mybatis.controller
 * @Author: zhengyuzhu
 * @CreateTime: 2024-08-29  15:51
 * @Description: TODO
 * @Version: 1.0
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 查询用户
     **/
    public Result queryUserById(){
        Integer id = 1;
        User user = userService.selectByPrimaryKey(id);
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("user",user);
        return Result.success().put("result",resultMap);
    }


}
