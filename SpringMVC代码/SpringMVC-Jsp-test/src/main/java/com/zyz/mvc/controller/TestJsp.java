package com.zyz.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zyz
 * @version 1.0
 * @data 2022/11/29 10:13
 * @Description:
 */
@Controller
public class TestJsp {
    @RequestMapping("/success")
    public String success(){
        return "success";
    }

}
