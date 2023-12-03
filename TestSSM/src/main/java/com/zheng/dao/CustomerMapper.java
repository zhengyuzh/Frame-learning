package com.zheng.dao;

import com.zheng.pojo.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerMapper {

    /**
     * 增加一个客户信息
     *
     * @param customer
     * @return
     */
    int addCustomer(Customer customer);

    /**
     * 根据顾客账号删除一个学生信息
     *
     * @param id
     * @return
     */
    int deleteCustomer(String id);

    /**
     * 增加一个客户信息
     *
     * @param usercount
     * @return
     */
    Customer queryCustomerById(String usercount);

    /**
     * 查询所有的用户信息
     *
     * @return
     */
    List<Customer> queryAllCustomer();
}
