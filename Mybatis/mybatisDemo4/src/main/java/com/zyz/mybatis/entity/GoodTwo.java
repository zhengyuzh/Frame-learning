package com.zyz.mybatis.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @BelongsProject: Mybatis
 * @BelongsPackage: com.zyz.mybatis.entity
 * @Author: zhengyuzhu
 * @CreateTime: 2024-10-28  09:58
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@TableName("goods")
public class GoodTwo {
    /**
     * 商品主键
     **/
    private Integer id;
    /**
     * 商品名称
     **/
    private String name;
}
