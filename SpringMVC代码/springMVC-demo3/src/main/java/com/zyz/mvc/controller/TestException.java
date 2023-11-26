package com.zyz.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zyz
 * @version 1.0
 * @data 2022/12/18 17:29
 * @Description:
 */
@Controller
public class TestException {

    /**
     * 测试异常跳转到指定页面
     * @return
     */
    @RequestMapping("/testException")
    public String testException(){
        System.out.println(1/0);
        return "success";
    }

}
