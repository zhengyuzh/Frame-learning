package com.zyz.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zyz
 * @version 1.0
 * @data 2022/11/28 9:47
 * @Description:
 */
@Controller
public class ViewController {

    /**
     * 测试testThymeleafView
     * @return
     */
    @RequestMapping("/testThymeleafView")
    public String testView(){
        return "success";
    }

    /**
     * 测试forward 转发
     * @return
     */
    @RequestMapping("/testForward")
    public String testForward(){
        return "forward:/testThymeleafView";
    }

    /**
     * 测试redirect 重定向
     * @return
     */
    @RequestMapping("/testRedirect")
    public String testRedirect(){
        return "redirect:/testThymeleafView";
    }

}
