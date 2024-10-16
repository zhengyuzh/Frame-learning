package com.zyz.mybatis.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyz.mybatis.entity.UserInfo;
import com.zyz.mybatis.mapper.UserInfoMapper;
import com.zyz.mybatis.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: Mybatis
 * @BelongsPackage: com.zyz.mybatis.service.Impl
 * @Author: zhengyuzhu
 * @CreateTime: 2024-08-30  08:43
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Autowired
    UserInfoMapper userMapper;

    /**
     * @description: 查询所有用户
     * @author: zhengyuzhu
     * @date: 2024/8/30 8:56
     * @return: java.util.List<com.zyz.mybatis.entity.User>
     **/
    @Override
    public List<UserInfo> findAllUser() {
       return userMapper.findAllUser();
    }

    /**
     * @description: 查询用户信息
     * @author: zhengyuzhu
     * @date: 2024/8/30 9:27
     * @return: com.zyz.mybatis.entity.UserInfo
     **/
    @Override
    public UserInfo getOneUser(Integer id) {
        return userMapper.selectById(id);
    }
}
