package com.zyz.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 拦截器
 * @author zyz
 * @version 1.0
 * @data 2022/12/18 14:24
 * @Description:
 */
@Controller
public class TestInterceptor {

    @RequestMapping("/testInterceptor")
    public String testInterceptor(){
        return "success";
    }
}
