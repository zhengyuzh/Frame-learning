package com.zyz.SpringDemo2.service;

import com.zyz.SpringDemo2.entity.Student;

import java.util.List;

/**
 * @BelongsProject: SpringDemo1
 * @BelongsPackage: com.zyz.SpringDemo2.service
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-16  22:35
 * @Description: TODO
 * @Version: 1.0
 */
public interface IStudentService {
    List<Student> queryAll();
    void addStudent(Student student);
}
