package com.zyz.mvc.controller;



import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author zyz
 * @version 1.0
 * @data 2022/12/18 17:41
 * @Description:
 */
//@ControllerAdvice
public class ExceptionController {


    /**
     * 通过注解的形式。1、类用@ControllerAdvice  2、方法用@ExceptionHandler
     * @param ex
     * @param model
     * @return
     */
    @ExceptionHandler(value = {ArithmeticException.class, NullPointerException.class})
    public String testExceptionDemo(Exception ex, Model model){
        model.addAttribute("ex",ex);
        return "error";
    }
}
