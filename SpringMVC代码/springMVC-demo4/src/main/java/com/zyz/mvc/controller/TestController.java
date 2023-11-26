package com.zyz.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Map;

/**
 * @author zyz
 * @version 1.0
 * @data 2022/11/27 20:58
 * @Description:
 */

@Controller
public class TestController {
//    @RequestMapping("/")
//    public String toIndex() {
//        return "test_view";
//    }


    /**
     * 使用servletAPI向request域对象共享数据
     *
     * @param request
     * @return
     */
    @RequestMapping("/testRequestScope")
    public String toSuccess(HttpServletRequest request) {
        request.setAttribute("testRequestScope", "Hello,ServletAPI");
        return "success";
    }

    /**
     * 测试ModelAndView
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        /**
         * ModelAndView有Model和View的功能
         * Model主要用于向请求域共享数据
         * View主要用于设置视图，实现页面跳转
         */
        ModelAndView mav = new ModelAndView();
        //用来处理模型数据，向请求域request共享数据
        mav.addObject("testRequestScope", "Hello,ModelAndView");
        //设置视图名称
        mav.setViewName("success");
        return mav;

    }

    /**
     * 测试Model
     * @param model
     * @return
     */
    @RequestMapping("/testModel")
    public String testModel(Model model){
        model.addAttribute("testRequestScope","Hello,Model");
        System.out.println(model.getClass().getName());
        return "success";
    }

    /**
     * 测试MaP
     * @param map
     * @return
     */
    @RequestMapping("/testMap")
    public String testMap(Map<String,Object> map){
        map.put("testRequestScope","Hello,Map");
        System.out.println(map.getClass().getName());
        return "success";
    }

    /**
     * 测试 ModelMap
     * @param modelMap
     * @return
     */
    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("testRequestScope","Hello,ModelMap");
        System.out.println(modelMap.getClass().getName());
        return "success";
    }

    /**
     * 测试Session
     * @param session
     * @return
     */
    @RequestMapping("/testSession")
    public String testSession(HttpSession session){
        session.setAttribute("testSession","Hello Session");
        return "success";

    }

    /**
     * 测试Application
     * @param session
     * @return
     */
    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session){
        ServletContext application = session.getServletContext();
        application.setAttribute("testApplication","Hello Application");
        return "success";
    }

    /**
     * 测试view
     * @return
     */
    @RequestMapping("/testView")
    public String testView(){
        return "test_view";
    }



}
