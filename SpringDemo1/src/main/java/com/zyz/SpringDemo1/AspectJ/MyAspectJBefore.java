package com.zyz.SpringDemo1.AspectJ;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


/**
 * @BelongsProject: SpringDemo1
 * @BelongsPackage: com.zyz.SpringDemo1.AspectJ
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-16  21:22
 * @Description: 声明切面
 * @Version: 1.0
 */
@Component
@Aspect
public class MyAspectJBefore {

    /**
     * 定义功能增强方法（方法就是切面）
     * 1、方法的必须为public
     * 2、方法无返回值
     * 3、方法名称自定义
     * 4、方法可以有参数，也可以没有参数
     * 5、方法的定义上方加入注解，表示切入点的执行时机

     @Before(value = "execution(public void com.mms.ba01.ServiceImpl.doSome(String,int))")
     public void beforeLog() {
     System.out.println("前置通知->系统当前时间：" + new Date());
     }
     */

    /**
     * @description: 前置通知，带方法参数的切面
     *         切面方法有参数时要求参数是JoinPoint类型，参数名自定义，该参数就代表了连接点方法，即doSome方法
     *         使用该参数可以获取切入点表达式、切入点方法签名、目标对象等
     * @author: zhengyuzhu
     * @date: 2023/11/16 21:30
     * @param: jp
     **/
    @Before(value = "execution(* *..ServiceImpl.doSome(..))")
    public void beforeLog(JoinPoint jp) {
        System.out.println("连接点方法的方法签名="+jp.getSignature());
        System.out.println("连接点方法的方法名="+jp.getSignature().getName());
        //获取连接点方法参数
        Object[] args = jp.getArgs();
        for (Object arg : args) {
            System.out.println("arg="+arg);
        }
    }


}
