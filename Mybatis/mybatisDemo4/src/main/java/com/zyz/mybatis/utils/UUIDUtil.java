package com.zyz.mybatis.utils;

import java.util.UUID;

/**
 * @BelongsProject: Mybatis
 * @BelongsPackage: com.zyz.mybatis.utils
 * @Author: zhengyuzhu
 * @CreateTime: 2024-11-04  11:14
 * @Description: TODO UUID生成工具类
 * @Version: 1.0
 */
public class UUIDUtil {
    public static String uuid(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
