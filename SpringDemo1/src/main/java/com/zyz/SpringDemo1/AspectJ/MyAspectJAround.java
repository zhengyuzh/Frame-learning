package com.zyz.SpringDemo1.AspectJ;

import com.zyz.SpringDemo1.entity.Student;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: SpringDemo1
 * @BelongsPackage: com.zyz.SpringDemo1.AspectJ
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-16  21:56
 * @Description: TODO
 * @Version: 1.0
 */
@Component
@Aspect
public class MyAspectJAround {


    /*
       环绕通知：@Around(切入点表达式)
        1、环绕通知是最重要的一个通知，他表示在连接点方法的前或者后都可以执行，它的本质就是jdk动态代理的invoke
           方法的method参数
        2、定义格式
            a、public
            b、必须有返回值，类型为Object

        再次回忆一下jdk动态代理的invoke方法的定义
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        是不是感觉与下面的方法定义眼熟啊，没错，环绕通知切面的定义实质上就是jdk动态代理
     */
    @Around(value = "pointCut()")
    public Object around(ProceedingJoinPoint pj) throws Throwable {
        System.out.println("环绕通知在连接点方法之前执行了...");
        Object result = null;
        result = pj.proceed();
        Student student = new Student();
        student.setName("李四");
        student.setAge(24);
        //改变连接点方法返回值
        result = student;
        System.out.println("事务已提交...");
        return result;
    }

    /*
        使用pointcut管理切面表达式
        1、在一个切面类中，若多个切面的切面表达式均为同一个，每次都要写重复的代码，此时就可以使用pointcut来
          管理切面表达式了
        2、定义格式：
            公共public
            无返回值
            无参数
     */
    @Pointcut(value = "execution(* *.doStudent(..))")
    public void pointCut() {
        //空方法体
    }
}
