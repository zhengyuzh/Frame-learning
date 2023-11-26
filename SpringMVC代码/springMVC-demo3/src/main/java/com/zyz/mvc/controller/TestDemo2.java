package com.zyz.mvc.controller;

import com.zyz.mvc.pojo.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zyz
 * @version 1.0
 * @data 2022/12/11 20:01
 * @Description:
 */
@Controller
public class TestDemo2 {

    /**
     * 测试requestBody
     * @param requestBody
     * @return
     */
    @RequestMapping(value = "/testRequestBody", method = RequestMethod.POST)
    public String testRequestBody(@RequestBody String requestBody) {
        System.out.println(requestBody);
        return "success";
    }

    /**
     * 测试requestEntity
     * @param requestEntity
     * @return
     */
    @RequestMapping(value = "/testRequestEntity", method = RequestMethod.POST)
    public String testRequestEntity(RequestEntity<String> requestEntity) {
        System.out.println("请求头：" + requestEntity.getHeaders());
        System.out.println("请求体：" + requestEntity.getBody());
        return "success";
    }

    /**
     * 测试response
     * @param response
     * @throws IOException
     */
    @RequestMapping("/testResponse")
    public void testResponse(HttpServletResponse response) throws IOException {
        response.getWriter().print("hello,Resopnse");
    }


    @RequestMapping("/testResponseBody")
    @ResponseBody
    public String testResponseBody() {
        return "success";
    }

    /**
     * 如果返回数组对象   返回一个对象
     * @return
     */
    @RequestMapping("/testResponseUser")
    @ResponseBody
    public List<User> testResponseUser() {
        User user1 = new User("张三", "男");
        User user2 = new User("李四", "男");
        ArrayList<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        return list;

    }

    /**
     * 测试axios
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/testAxios")
    @ResponseBody
    public String testAxios(String username,String password){
        System.out.println("姓名："+username+",密码："+password);
        return "hello,axios";
    }

}
