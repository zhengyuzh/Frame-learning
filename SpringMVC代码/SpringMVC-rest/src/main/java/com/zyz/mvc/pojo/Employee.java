package com.zyz.mvc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zyz
 * @version 1.0
 * @data 2022/11/28 21:54
 * @Description:
 */
@Data
@AllArgsConstructor
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;

}
