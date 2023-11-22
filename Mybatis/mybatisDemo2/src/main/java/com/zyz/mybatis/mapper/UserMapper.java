package com.zyz.mybatis.mapper;

import com.zyz.mybatis.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/11/22 14:37
 * @Description: User 实体类
 */
public interface UserMapper {
    /**
     * @description: 查询用户
     * @author: zhengyuzhu
     * @date: 2023/11/22 14:40
     * @return: java.util.List<com.zyz.mybatis.entity.User>
     **/
    @Select("select * from user")
    List<User> getUsers();

}
