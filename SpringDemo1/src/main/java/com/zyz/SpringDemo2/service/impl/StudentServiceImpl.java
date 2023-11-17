package com.zyz.SpringDemo2.service.impl;

import com.zyz.SpringDemo2.entity.Student;
import com.zyz.SpringDemo2.mapper.StudentMapper;
import com.zyz.SpringDemo2.service.IStudentService;

import java.util.List;

/**
 * @BelongsProject: SpringDemo1
 * @BelongsPackage: com.zyz.SpringDemo2.service.serviceImpl
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-16  22:35
 * @Description: TODO
 * @Version: 1.0
 */
public class StudentServiceImpl implements IStudentService {
    //mapper属性
    private StudentMapper mapper;
    //set注入给mapper对象赋值
    public void setMapper(StudentMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<Student> queryAll() {
        return mapper.queryAll();
    }

    @Override
    public void addStudent(Student student) {
        mapper.addStudent(student);
    }
}
