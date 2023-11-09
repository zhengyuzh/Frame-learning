package com.zyz.SpringDemo1.entity;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/11/9 11:13
 * @Description:  学生家庭地址
 */
public class Address {
    private String province;
    private String city;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
