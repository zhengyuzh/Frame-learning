package com.zyz.mybatis.system.userManage.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @BelongsProject: Mybatis
 * @BelongsPackage: com.zyz.mybatis.system.userManage.entity
 * @Author: zhengyuzhu
 * @CreateTime: 2024-10-31  11:03
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@TableName("user")
public class User {
    /**
     * 用户主键
     **/
    private Integer id;
    /**
     * 用户姓名
     **/
    private String name;
    /**
     * 用户密码
     **/
    private String pwd;
}
