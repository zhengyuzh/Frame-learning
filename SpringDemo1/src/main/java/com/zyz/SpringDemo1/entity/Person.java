package com.zyz.SpringDemo1.entity;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/11/8 13:58
 * @Description: 用户实体
 */
public class Person {
    private Integer id;
    private String name;
    private String age;

    public Person() {
    }

    public Person(Integer id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    //定义一个方法
    public void say() {
        System.out.println("我是Person中的方法");
    }
}
