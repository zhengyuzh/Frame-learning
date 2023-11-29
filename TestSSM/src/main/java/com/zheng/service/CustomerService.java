package com.zheng.service;

import com.zheng.pojo.Customer;

import java.util.List;

public interface CustomerService {

    //根据学号查看学生信息
    Customer queryCustomerById(String id);

    //根据学号查询
    List<Customer> queryAllCustomer();

    //增加用户信息
    public boolean addCustomer(Customer customer);

    //删除用户信息
    public boolean deleteCustomer(String id);
}
