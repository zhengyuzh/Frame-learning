package com.zyz.mybatis.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @BelongsProject: Mybatis
 * @BelongsPackage: com.zyz.mybatis.utils
 * @Author: zhengyuzhu
 * @Description: TODO ip地址获取工具类
 * @Version: 1.0
 */
public class IPUtils {
    private static Logger log = LoggerFactory.getLogger(IPUtils.class);


    /**
     * @description:获取本机地址IP
     * @author: zhengyuzhu
     * @date: 2024/11/4 11:26
     * @param: request
     * @return: java.lang.String
     **/
    public static String getLocalIpAddr() {
        String ipAddress = "";
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            ipAddress = localHost.getHostAddress();
            // 输出IP地址
        } catch (UnknownHostException exp) {
            log.error("==获取IP通知异常==");
            log.error("异常信息:{}", exp.getMessage());
            exp.printStackTrace();
        }
        return ipAddress;

    }

}
