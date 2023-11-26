package com.zyz.mvc.controller;

import com.sun.deploy.net.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author Lenovo
 * @version 1.0
 * @data 2022/11/7 17:45
 */
@Controller
public class paramController {
    @RequestMapping("/myTestParam")
    public String myTest(User user){
        System.out.println(user);
        return "param_test";
    }

    @RequestMapping("/testParam")
    public String testParam(@RequestParam(value = "user_name", required = false,defaultValue = "hello") String username, String password, String[] hobby,
                            @RequestHeader(value = "ShowHost" ,required = true,defaultValue = "MyHost") String host) {
        System.out.println("username:" + username + ",password:" + password + ",hobby:" + Arrays.toString(hobby)+",Host:"+host);
        return "param_test";

    }
}
