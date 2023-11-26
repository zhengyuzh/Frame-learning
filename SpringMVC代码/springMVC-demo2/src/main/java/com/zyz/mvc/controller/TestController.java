package com.zyz.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Lenovo
 * @version 1.0
 * @data 2022/11/1 23:03
 */
@Controller
//@RequestMapping("/hello")
public class TestController {

    @RequestMapping("/mytest/{id}/{username}")
    public String myTest(@PathVariable("id") String id,@PathVariable("username") String username) {
        System.out.println("id："+ id+",username:"+username);
        return "success";
    }


    /**
     * 此时请求的路径是/hello/test
     *
     * @return
     */
//    @RequestMapping("/test")
    @RequestMapping(
            value = {"/test", "/myTest"},
            method = {RequestMethod.GET, RequestMethod.POST},
            params = {"username","password!=1234"},
            headers = {"Host=localhost:8080"}
    )
    public String success() {
        return "success";
    }
}
