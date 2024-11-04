package com.zyz.mybatis.base.audit;

import com.zyz.mybatis.base.entity.SysLog;
import com.zyz.mybatis.base.service.LogOperateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: Mybatis
 * @BelongsPackage: zyz.audit
 * @Author: zhengyuzhu
 * @CreateTime: 2024-11-04  11:09
 * @Description: TODO
 * @Version: 1.0
 */
@Component
@EnableAsync
public class SystemLogAsyncTask {
    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private LogOperateService logOperateService;

    /**
     * 异步保存操作日志
     * 使用 @Async 注解：这会自动处理异步调用，无需显式实现 Runnable 接口。
     */
    @Async
    public void saveOperateLog(SysLog info)
    {
        logOperateService.save(info);
    }

}
