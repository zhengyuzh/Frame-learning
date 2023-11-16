package com.zyz.SpringDemo1.dao;

import org.springframework.stereotype.Repository;

/**
 * @BelongsProject: SpringDemo1
 * @BelongsPackage: com.zyz.SpringDemo1.dao
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-16  09:01
 * @Description: TODO
 * @Version: 1.0
 */
@Repository("userDaoImplTwo") //起个名称
public class UserDaoImplTwo implements UserDao{
    @Override
    public void showTime() {
        System.out.println("UserDaoImplTwo showTime ......");

    }
}
