package com.zyz.mybatis.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyz.mybatis.base.entity.SysLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zyz
 * @version 1.0
 * @data 2024/10/31 16:38
 * @Description:
 */
@Mapper
public interface LogOperateMapper extends BaseMapper<SysLog> {
}
