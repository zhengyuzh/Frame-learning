package com.zheng.controller;


import com.zheng.pojo.Customer;
import com.zheng.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    @Qualifier("CustomerServiceImpl")
    private CustomerService customerService;


    @RequestMapping("/login")
    public String login(String usercount, Model model) {
        Customer customer = customerService.queryCustomerById(usercount);

        if (customer == null) {
            model.addAttribute("error", "用户不存在，请注册后使用");
            return "redirect:../login.jsp";
        } else {
            model.addAttribute("success", "登录成功");
            return "redirect:/book/queryAll";
        }

    }

    @RequestMapping("/allcustomer")
    public String list(Model model, String usercount) {
        try {

            List<Customer> list = customerService.queryAllCustomer();
            if (list == null) {
                model.addAttribute("error", "用户列表为空");
            } else {
                model.addAttribute("list", list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "allCustomer";

    }

    /**
     * 增加用户信息
     * @param model
     * @param customer
     * @return
     */
    @RequestMapping("addCustomer")
    public String addCustomer(Model model, Customer customer) {

        try {
            //1、首先判断用户是否存在，存在告诉用户
            Customer customer1 = customerService.queryCustomerById("customer.getUsercount()");
            if (customer1 != null) {
                //已经存在用户
                return "redirect:../login.jsp";
            } else {
                boolean flag;
                flag = customerService.addCustomer(customer);
                if (flag) {
                    model.addAttribute("success", "添加成功");
                } else {
                    model.addAttribute("fail", "增加失败");
                }
                return "redirect:/customer/allcustomer";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:../login.jsp";
        }


    }

    @RequestMapping("/delete")
    public String deleteCustomerById(String id,Model model){

        boolean flag=customerService.deleteCustomer(id);

        if(flag ){
            model.addAttribute("success","删除成功");
        }else{
            model.addAttribute("faile","删除失败");
        }

        return "allCustomer";

    }


}
