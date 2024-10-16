package com.zyz.mybatis.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @BelongsProject: Mybatis
 * @BelongsPackage: com.zyz.mybatis.entity
 * @Author: zhengyuzhu
 * @CreateTime: 2024-08-30  09:30
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@TableName("user")
public class UserInfo {
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
