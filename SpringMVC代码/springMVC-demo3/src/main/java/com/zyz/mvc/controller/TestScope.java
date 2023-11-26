package com.zyz.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zyz
 * @version 1.0
 * @data 2022/11/13 21:37
 * @Description:
 */
@Controller
public class TestScope {

//    @RequestMapping("/")
//    public String toIndex(){
//        return "index";
//    }

    @RequestMapping("/servletApi")
    public String toSuccess(HttpServletRequest request){
        request.setAttribute("testRequest","hello springMVC");
        return "success";
    }
}
