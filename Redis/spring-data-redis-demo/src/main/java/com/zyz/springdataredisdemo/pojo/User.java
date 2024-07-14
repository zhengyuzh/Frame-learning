package com.zyz.springdataredisdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: Redis
 * @BelongsPackage: com.zyz.springdataredisdemo.pojo
 * @Author: zhengyuzhu
 * @CreateTime: 2024-07-13  21:47
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private Integer age;
}
