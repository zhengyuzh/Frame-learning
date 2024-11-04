package com.zyz.mybatis.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @BelongsProject: Mybatis
 * @BelongsPackage: com.zyz.mybatis.base.entity
 * @Author: zhengyuzhu
 * @CreateTime: 2024-10-31  16:36
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@TableName("syslog")
public class SysLog implements Serializable {

    private static final long serialVersionUID = 6182609441457492732L;
    /**
     * 日志主键
     **/
    private String id;
    /**
     * 用户姓名
     **/
    private String username;
    /**
     * 操作描述
     **/
    private String operation;
    /**
     * 调用方法
     **/
    private String method;
    /**
     * 入参
     **/
    private String params;
    /**
     * 操作IP
     **/
    private String ip;
    /**
     * 操作时间
     **/
    private Long createTime;
}
