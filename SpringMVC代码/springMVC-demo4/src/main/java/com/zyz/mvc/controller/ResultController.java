package com.zyz.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author zyz
 * @version 1.0
 * @data 2022/11/28 15:17
 * @Description:
 */

@Controller
public class ResultController {
    /**
     *  使用RESULT模拟用户资源的增删改查
     *


     /**
     *查询所有用户信息
     * @return
     */
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getAllUser(){
        System.out.println("查询所有用户信息");
        return "success";
    }

    /**
     * 根据ID查询用户信息
     * @return
     */
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String getUserById(){
        System.out.println("根据ID查询用户信息");
        return "success";
    }

    /**
     * 添加用户
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String addUser(String username,String password){
        System.out.println("添加用户信息："+username+","+password);
        return "success";
    }

    /**
     * 修改用户
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String updateUser(String username,String password){
        System.out.println("修改用户信息："+username+","+password);
        return "success";
    }




}
