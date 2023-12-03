package com.zheng.service.impl;

import com.zheng.dao.CustomerMapper;
import com.zheng.pojo.Customer;
import com.zheng.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    public void setCustomerMapper(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    /**
     * 查询学生
     * @param usercount
     * @return
     */
    @Override
    public Customer queryCustomerById(String usercount) {
        Customer customer=null;
        try {
            customer=customerMapper.queryCustomerById(usercount);
            System.out.println("CustomerServiceImpl-queryCustomerById ：success");
        } catch (Exception e) {
            System.out.println("CustomerServiceImpl-queryCustomerById ：fail");
            e.printStackTrace();
        }
        return customer;
    }


    /**
     * 查询全部信息
     * @return
     */
    @Override
    public List<Customer> queryAllCustomer() {
        List<Customer> list=null;
        try {
            list=customerMapper.queryAllCustomer();
            System.out.println("CustomerServiceImpl-queryAllCustomer:success"+list.size());
        } catch (Exception e) {
            System.out.println("CustomerServiceImpl-queryAllCustomer:fail");
            e.printStackTrace();
        }

        return list;
    }

    /**
     * 增加用户信息
     * @param customer
     * @return
     */
    @Override
    public boolean addCustomer(Customer customer) {
        boolean flag=false;

        try {
            int i=customerMapper.addCustomer(customer);
            if(i >0) {
                flag=true;
                System.out.println("CustomerServiceImpl-addCustomer:success");
            }else{
                System.out.println("CustomerServiceImpl-addCustomer:fail");
            }
        } catch (Exception e) {
            System.out.println("CustomerServiceImpl-addCustomer:异常信息");
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 删除一个学生信息
     * @param id
     * @return
     */
    @Override
    public boolean deleteCustomer(String id) {
        boolean flag=false;
        try {
            int i=customerMapper.deleteCustomer(id);
            if(i>0){
                flag=true;
                System.out.println("CustomerServiceImpl-deleteCustomer:success");
            }else{
                System.out.println("CustomerServiceImpl-deleteCustomer:fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


}
