package com.zyz.mybatis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zyz.mybatis.entity.UserInfo;

import java.util.List;

/**
 * @author zyz
 * @version 1.0
 * @data 2024/8/30 8:42
 * @Description:
 */
public interface UserInfoService extends IService<UserInfo> {

    /**
     * @description: 查询所有用户
     * @author: zhengyuzhu
     * @date: 2024/8/30 8:56
     * @return: java.util.List<com.zyz.mybatis.entity.User>
     **/
    List<UserInfo> findAllUser();


    /**
     * @description: 查询用户信息
     * @author: zhengyuzhu
     * @date: 2024/8/30 9:27
     * @return: com.zyz.mybatis.entity.UserInfo
     **/
    UserInfo getOneUser(Integer id);
}
