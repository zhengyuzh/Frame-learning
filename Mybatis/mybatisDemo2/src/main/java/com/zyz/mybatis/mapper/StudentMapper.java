package com.zyz.mybatis.mapper;

import com.zyz.mybatis.entity.Student;

import java.util.List;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/11/22 22:24
 * @Description:
 */
public interface StudentMapper {
    /**
     * @description: 查询学生
     * @author: zhengyuzhu
     * @date: 2023/11/22 22:27
     * @return: java.util.List<com.zyz.mybatis.entity.Student>
     **/
    List<Student> getStudent();


    /**
     * @description: 查询学生
     * @author: zhengyuzhu
     * @date: 2023/11/22 22:27
     * @return: java.util.List<com.zyz.mybatis.entity.Student>
     **/
    List<Student> getStudent2();

}
