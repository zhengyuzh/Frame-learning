package com.zyz.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: Mybatis
 * @BelongsPackage: com.zyz.mybatis.entity
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-22  16:54
 * @Description: 实体类地址 省
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String name;
    private String city;
    private String province;
}
