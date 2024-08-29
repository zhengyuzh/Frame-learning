package com.zyz.mybatis.service;

import com.zyz.mybatis.entity.User;

/**
 * @author zyz
 * @version 1.0
 * @data 2024/8/29 15:52
 * @Description:
 */
public interface UserService {
    /**
     * 查询用户
     **/
    User selectByPrimaryKey(Integer id);

}
