package com.zyz.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: Mybatis
 * @BelongsPackage: com.zyz.mybatis.entity
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-22  22:21
 * @Description: Student 实体类
 * @Version: 1.0
 */
@Data                              //get，set
@NoArgsConstructor                 //无参构造
@AllArgsConstructor                //有参构造
public class Student {

    private Integer id;
    private String name;
    private Teacher teacher;

}
