package com.zyz.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author Lenovo
 * @version 1.0
 * @data 2022/10/30 16:41
 */
@Controller
public class HelloSpringMVC {
/**
 * @RequestMapping注解：处理请求和控制器方法之间的映射关系
 * @RequestMapping注解的value属性可以通过请求地址匹配请求，/表示的当前工程的上下文路径
 * localhost:8080/springMVC/
 */
    @RequestMapping(value = "/")
    public String index(){
        //返回视图名称
        return "index";
    }

    @RequestMapping(value = "/target")
    public String toTarget(){
        //返回目标页面
        return "target";
    }

}
