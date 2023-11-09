package com.zyz.SpringDemo1.entity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/11/9 10:01
 * @Description: 大学生实体类
 */
public class UniversityStudent {
    private String name;

    /**
     * 1、数组类型属性 课程
     */
    private String [] courses;

    /**
     * 2、list集合类型属性 水果
     */
    private List<String> fruitList;

    /**
     * 3、map集合类型属性 体育运动
     */
    private Map<String,String> sportMaps;

    /**
     * 4、set集合类型属性 爱好
     */
    private Set<String> hobbySets;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getCourses() {
        return courses;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public List<String> getFruitList() {
        return fruitList;
    }

    public void setFruitList(List<String> fruitList) {
        this.fruitList = fruitList;
    }

    public Map<String, String> getSportMaps() {
        return sportMaps;
    }

    public void setSportMaps(Map<String, String> sportMaps) {
        this.sportMaps = sportMaps;
    }

    public Set<String> getHobbySets() {
        return hobbySets;
    }

    public void setHobbySets(Set<String> hobbySets) {
        this.hobbySets = hobbySets;
    }

    @Override
    public String toString() {
        return "UniversityStudent{" +
                "name='" + name + '\'' +
                ", courses=" + Arrays.toString(courses) +
                ", fruitList=" + fruitList +
                ", sportMaps=" + sportMaps +
                ", hobbySets=" + hobbySets +
                '}';
    }
}

