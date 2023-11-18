package com.zyz.SpringDemo3.service.impl;

/**
 * @BelongsProject: SpringDemo1
 * @BelongsPackage: com.zyz.SpringDemo3.service.impl
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-18  15:57
 * @Description: 定义异常类
 * @Version: 1.0
 */
public class NotEnoughException extends RuntimeException {
    public NotEnoughException() {

    }
    public NotEnoughException(String msg) {
        super(msg);
    }
}

