package com.zyz.SpringDemo1.service.impl;

import com.zyz.SpringDemo1.entity.Student;
import com.zyz.SpringDemo1.service.IService;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: SpringDemo1
 * @BelongsPackage: com.zyz.SpringDemo1.service.impl
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-16  21:21
 * @Description: TODO
 * @Version: 1.0
 */
@Component(value = "service")
public class ServiceImpl implements IService {

    @Override
    public Student doStudent(Student student) {
        return student;
    }

    @Override
    public void doSome(String name, int age) {
        System.out.println("===doSome()===");
    }
}
