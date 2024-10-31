package com.zyz.mybatis.system.userManage.service;

import com.zyz.mybatis.common.Result;
import com.zyz.mybatis.system.userManage.entity.User;

import java.util.List;

/**
 * @BelongsProject: Mybatis
 * @BelongsPackage: com.zyz.mybatis.system.userManage.service
 * @Author: zhengyuzhu
 * @CreateTime: 2024-10-31  11:04
 * @Description: TODO
 * @Version: 1.0
 */
public interface UserService {
    List<User> getUserList();
}
