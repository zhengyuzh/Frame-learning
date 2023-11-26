package com.zyz.mvc.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 * @author zyz
 * @version 1.0
 * @data 2022/12/18 14:15
 * @Description:
 */
@Component
public class SecondInterceptor implements HandlerInterceptor {
    /**
     * 方法执行前
     * CTRL+O 重写的快捷键
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("SecondInterceptor--->:preHandle");

        /**
         * 如果返回false、视图页面不出效果，由源码得知、走到一般返回了。没有到视图解析那一步
         */
        return true;
    }

    /**
     * 方法执行后
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("SecondInterceptor--->:postHandle");

    }

    /**
     * 视图渲染后执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("SecondInterceptor--->:afterCompletion");

    }
}
