package com.zyz.mybatis.mapper;


import com.zyz.mybatis.entity.Student;

import java.util.HashMap;
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
     * @description: 模糊查询
     * @author: zhengyuzhu
     * @date: 2023/11/21 21:39
     * @param: like
     * @return: java.util.List<com.zyz.mybatis.entity.Student>
     **/
    List<Student> getStudentLike(String value);

    /**
     * @description: 新增学生
     * @author: zhengyuzhu
     * @date: 2023/11/16 22:34
     * @param: student
     *
     * @return*/
    Integer addStudent(Student student);

    /**
     * @description: 根据学号查询学生
     * @author: zhengyuzhu
     * @date: 2023/11/20 22:43
     * @param: stuNo
     * @return: com.zyz.mybatis.entity.Student
     **/
    Student queryStudentById(Integer stuNo);

    /**
     * @description: 修改学生信息
     * @author: zhengyuzhu
     * @date: 2023/11/20 22:45
     * @param: student
     * @return: java.lang.Integer
     **/
    Integer updateStudent(Student student);

    /**
     * @description: 通过Map 修改学生信息
     * @author: zhengyuzhu
     * @date: 2023/11/21 21:08
     * @param: studentMap
     * @return: java.lang.Integer
     **/
    Integer updateStudentMap(HashMap<String,Object> studentMap);

    /**
     * @description:删除学生 通过 学号
     * @author: zhengyuzhu
     * @date: 2023/11/20 22:45
     * @param: stuNo
     * @return: java.lang.Integer
     **/
    Integer deleteStudentById(Integer stuNo);
}
