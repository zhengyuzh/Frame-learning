package com.zyz.SpringDemo1.dao;

import org.springframework.stereotype.Repository;

/**
 * @BelongsProject: SpringDemo1
 * @BelongsPackage: com.zyz.SpringDemo1.dao
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-15  22:52
 * @Description: TODO
 * @Version: 1.0
 */

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void showTime() {
        System.out.println("UserDaoImpl showTime ......");
    }
}
