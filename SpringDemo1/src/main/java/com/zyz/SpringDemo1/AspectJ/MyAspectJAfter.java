package com.zyz.SpringDemo1.AspectJ;

import com.zyz.SpringDemo1.entity.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: SpringDemo1
 * @BelongsPackage: com.zyz.SpringDemo1.AspectJ
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-16  21:42
 * @Description: TODO
 * @Version: 1.0
 */
@Component
@Aspect
public class MyAspectJAfter {
    /**
     * @AfterReturning: 后置通知，在连接点方法执行之后执行后置通知方法
     * 方法定义格式：
     * 1、公共方法
     * 2、没有返回值
     * 3、方法名称自定义
     * 4、与前置通知一样，可以有JoinPoint类型参数，该参数表示连接点方法对象；还可以有一个
     *    Object类型参数，用于接收连接点方法的执行结果，注意该参数的参数名必须与切入点表达式
     *    的returning属性的属性值一致，表示将returning属性值赋给Object对象
     */
    /*@AfterReturning(value = "execution(* *..ServiceImpl.doOther(..))", returning = "obj")
        public void afterTransaction(JoinPoint jp, Object obj) {
        System.out.println("doOther方法的返回参数="+obj);
        System.out.println("事务已提交...");
        经过验证：在后置通知切面内不能改变连接点方法的返回值
    }*/

    @AfterReturning(value = "execution(* *..ServiceImpl.doStudent(..))", returning = "obj")
    public void afterTransaction(JoinPoint jp, Object obj) {
        System.out.println(obj);
        Student student = new Student();
        student.setName("李四");
        student.setAge(24);
        obj = student;
        System.out.println("===查看是否改变了连接点方法的返回值==="+obj);
        /*
            经过验证：在后置通知切面内不能改变连接点方法的返回值
         */
    }
}