package com.zyz.mybatis.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @BelongsProject: Mybatis
 * @BelongsPackage: com.zyz.mybatis.vo
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-22  23:47
 * @Description: TODO
 * @Version: 1.0
 */
@Data                              //get，set
@NoArgsConstructor                 //无参构造
@AllArgsConstructor                //有参构造
public class TeacherT {
    private Integer id;
    private String name;
    private List<StudentT> studentTs;

}

