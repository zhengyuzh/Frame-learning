package com.zyz.SpringDemo1.entity;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/11/9 15:08
 * @Description:
 */
public class PrimaryAddress extends Address{
    private String name;
    private Integer hisotry;
    private Address address;

    public PrimaryAddress(){}

    public PrimaryAddress(String name, Integer hisotry, Address address) {
        this.name = name;
        this.hisotry = hisotry;
        this.address = address;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", hisotry=" + hisotry +
                '}';
    }
}
