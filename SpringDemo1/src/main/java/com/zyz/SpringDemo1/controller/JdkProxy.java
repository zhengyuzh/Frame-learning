package com.zyz.SpringDemo1.controller;

import com.zyz.SpringDemo1.dao.DynamicProxiesDao;
import com.zyz.SpringDemo1.dao.DynamicProxiesDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @BelongsProject: SpringDemo1
 * @BelongsPackage: com.zyz.SpringDemo1.controller
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-16  20:43
 * @Description: TODO
 * @Version: 1.0
 */

public class JdkProxy {
    public static void main(String[] args) {
        //创建接口实现类代理对象
        Class[] interfaces = {DynamicProxiesDao.class};
//        Proxy.newProxyInstance(JdkProxy.class.getClassLoader(), interfaces,
//                new InvocationHandler() {
//                    @Override
//                    public Object invoke(Object proxy, Method method, Object[] args)
//                            throws
//                            Throwable {
//                        return null;
//                    }
//                });
        DynamicProxiesDaoImpl dynamicProxiesDao = new DynamicProxiesDaoImpl();
        DynamicProxiesDao dao = (DynamicProxiesDao) Proxy.newProxyInstance(JdkProxy.class.getClassLoader(), interfaces, new DynamicProxiesDaoProxy(dynamicProxiesDao));
        int rs = dao.add(4, 5);
        System.out.println("result:" + rs);

        //测试结果
        // 方法执行之前:add，传递的参数是：[4, 5]
        // 执行了add方法
        // 方法执行之后：com.zyz.SpringDemo1.dao.DynamicProxiesDaoImpl@63947c6b
        // result:9

    }
}

/**
 * 代理对象代码
 */
class DynamicProxiesDaoProxy implements InvocationHandler {
    /**
     * 1 把创建的是谁的代理对象，把谁传递过来
     *  有参数构造传递
     */
    private Object obj;

    public DynamicProxiesDaoProxy(Object obj) {
        this.obj = obj;
    }


    /**
     *  增强的逻辑
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //方法之前
        System.out.println("方法执行之前:" + method.getName() + "，传递的参数是：" + Arrays.toString(args));
        //被增强的方法执行
        Object rs = method.invoke(obj, args);
        //方法之后
        System.out.println("方法执行之后：" + obj);
        return rs;
    }


}
