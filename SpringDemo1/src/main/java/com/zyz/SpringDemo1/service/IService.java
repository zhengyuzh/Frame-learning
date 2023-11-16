package com.zyz.SpringDemo1.service;

import com.zyz.SpringDemo1.entity.Student;
import org.springframework.stereotype.Component;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/11/16 21:20
 * @Description: 声明接口IService
 */

public interface IService {

    Student doStudent(Student student);

    void doSome(String name, int age);
}
