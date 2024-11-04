package com.zyz.mybatis.base.service.impl;

import com.zyz.mybatis.base.entity.SysLog;
import com.zyz.mybatis.base.mapper.LogOperateMapper;
import com.zyz.mybatis.base.service.LogOperateService;
import com.zyz.mybatis.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: Mybatis
 * @BelongsPackage: com.zyz.mybatis.base.service.impl
 * @Author: zhengyuzhu
 * @CreateTime: 2024-10-31  16:33
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class LogOperateServiceImpl implements LogOperateService {

    @Autowired
    LogOperateMapper logOperateMapper;

    @Override
    public void save(SysLog info) {
        info.setId(UUIDUtil.uuid());
        logOperateMapper.insert(info);
    }
}
