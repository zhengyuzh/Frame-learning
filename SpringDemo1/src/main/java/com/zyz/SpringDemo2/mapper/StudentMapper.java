package com.zyz.SpringDemo2.mapper;

import com.zyz.SpringDemo2.entity.Student;

import java.util.List;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/11/16 22:33
 * @Description:
 */
public interface StudentMapper {
    /**
     * @description: 查询全部
     * @author: zhengyuzhu
     * @date: 2023/11/16 22:34
     * @return: java.util.List<com.zyz.SpringDemo2.entity.Student>
     **/
    List<Student> queryAll();

    /**
     * @description: 新增学生
     * @author: zhengyuzhu
     * @date: 2023/11/16 22:34
     * @param: student
     **/
    void addStudent(Student student);
}
