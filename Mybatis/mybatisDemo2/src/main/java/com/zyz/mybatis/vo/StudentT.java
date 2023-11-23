package com.zyz.mybatis.vo;

import com.zyz.mybatis.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: Mybatis
 * @BelongsPackage: com.zyz.mybatis.vo
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-22  23:46
 * @Description: TODO
 * @Version: 1.0
 */
@Data                              //get，set
@NoArgsConstructor                 //无参构造
@AllArgsConstructor                //有参构造
public class StudentT {
    private Integer id;
    private String name;
    private Integer tid;

}
