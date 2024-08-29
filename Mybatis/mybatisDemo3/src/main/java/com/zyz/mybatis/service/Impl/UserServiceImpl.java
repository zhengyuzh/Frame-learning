package com.zyz.mybatis.service.Impl;

import com.zyz.mybatis.entity.User;
import com.zyz.mybatis.mapper.UserMapper;
import com.zyz.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: Mybatis
 * @BelongsPackage: com.zyz.mybatis.service.Impl
 * @Author: zhengyuzhu
 * @CreateTime: 2024-08-29  15:52
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
