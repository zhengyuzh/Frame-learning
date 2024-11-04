package com.zyz.mybatis.base.config;

import com.zyz.mybatis.base.audit.SystemLogAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @BelongsProject: Mybatis
 * @BelongsPackage: com.zyz.mybatis.base.config
 * @Author: zhengyuzhu
 * @Description: TODO AOP启动配置类
 * @Version: 1.0
 */
@Configuration
@EnableAspectJAutoProxy
public class AppConfig {


    /**
     *  定义切面 bean（如果切面没有使用 @Component 注解）
     *      如果这里使用@Bean注解，同时在切面中使用@Component 注解
     *      则会加载两次切面，写入数据库两次。
     *     【注意：两者只能选择其一】
     *
     **/
    // @Bean
    public SystemLogAspect loggingAspect() {
        return new SystemLogAspect();
    }
}
