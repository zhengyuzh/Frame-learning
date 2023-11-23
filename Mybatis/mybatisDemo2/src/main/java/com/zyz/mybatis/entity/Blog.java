package com.zyz.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @BelongsProject: Mybatis
 * @BelongsPackage: com.zyz.mybatis.entity
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-23  11:15
 * @Description: Blog 实体类
 * @Version: 1.0
 */
@Data                              //get，set
@NoArgsConstructor                 //无参构造
@AllArgsConstructor                //有参构造
public class Blog {
    private Integer id;
    private String title;
    private String author;
    private String createTime; //属性名和字段名不一致
    private int views;
}
