package com.zyz.mybatis.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @BelongsProject: Mybatis
 * @BelongsPackage: com.zyz.mybatis.common
 * @Author: zhengyuzhu
 * @CreateTime: 2024-08-30  08:50
 * @Description: TODO
 * @Version: 1.0
 */
/**
 *返回结果类统一封装
 */
@Data
public class Result implements Serializable {
    // 状态码
    private Integer code;
    // 消息
    private String message;
    // 数据对象
    private Object result;

    private Integer total;

    /**
     * 无参构造器
     */
    public Result() {
        super();
    }

    public Result(Status status) {
        super();
        this.code = status.code;
        this.message = status.message;
    }

    public Result result(Object result) {
        this.result = result;
        return this;
    }

    public Result message(String message) {
        this.message = message;
        return this;
    }
    public Result total(Integer total) {
        this.total = total;
        return this;
    }

    /**
     * 只返回状态，状态码，消息
     *
     * @param code
     * @param message
     */
    public Result(Integer code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    /**
     * 只返回状态，状态码，数据对象
     *
     * @param code
     * @param result
     */
    public Result(Integer code, Object result) {
        super();
        this.code = code;
        this.result = result;
    }

    /**
     * 返回全部信息即状态，状态码，消息，数据对象
     *
     * @param code
     * @param message
     * @param result
     */
    public Result(Integer code, String message, Object result) {
        super();
        this.code = code;
        this.message = message;
        this.result = result;
    }
}
