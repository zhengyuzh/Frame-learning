package com.zyz.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyz.mybatis.entity.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zyz
 * @version 1.0
 * @data 2024/8/30 8:45
 * @Description:
 */
@Repository
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    /**
     * @description: 查询所有用户
     * @author: zhengyuzhu
     * @date: 2024/8/30 8:59
     * @return: java.util.List<com.zyz.mybatis.entity.User>
     **/
   List<UserInfo> findAllUser();
}
