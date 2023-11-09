package com.zyz.SpringDemo1.entity;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/11/9 8:42
 * @Description: 学生类
 */
public class Student {
    private String name;
    private Integer age;

    private Address address; // 引用类型属性

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    // @Override
    // public String toString() {
    //     return "Student{" +
    //             "name='" + name + '\'' +
    //             ", age=" + age +
    //             '}';
    // }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
