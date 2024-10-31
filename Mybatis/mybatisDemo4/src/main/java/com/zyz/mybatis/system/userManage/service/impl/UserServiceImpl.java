package com.zyz.mybatis.system.userManage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zyz.mybatis.common.Result;
import com.zyz.mybatis.system.userManage.entity.User;
import com.zyz.mybatis.system.userManage.mapper.UserMapper;
import com.zyz.mybatis.system.userManage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @BelongsProject: Mybatis
 * @BelongsPackage: com.zyz.mybatis.system.userManage.service.impl
 * @Author: zhengyuzhu
 * @CreateTime: 2024-10-31  11:04
 * @Description: TODO
 * @Version: 1.0
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public List<User> getUserList() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        List<User> userList = userMapper.selectList(lambdaQueryWrapper);
        return userList;
    }
}
