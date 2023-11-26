package com.zyz.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Lenovo
 * @version 1.0
 * @data 2022/11/1 22:28
 */
@Controller
public class MyController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
