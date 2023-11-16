package com.zyz.SpringDemo1.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @BelongsProject: SpringDemo1
 * @BelongsPackage: com.zyz.SpringDemo1.config
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-16  22:04
 * @Description: TODO
 * @Version: 1.0
 */
@Configuration
@ComponentScan(basePackages = {"com.zyz"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigAop {
}
