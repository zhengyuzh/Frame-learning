package com.zyz.SpringDemo1.dao;

/**
 * @BelongsProject: SpringDemo1
 * @BelongsPackage: com.zyz.SpringDemo1.dao
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-16  20:42
 * @Description: TODO
 * @Version: 1.0
 */
public class DynamicProxiesDaoImpl implements DynamicProxiesDao{
    @Override
    public int add(int a, int b) {
        System.out.println("执行了add方法");
        return a+b;
    }

    @Override
    public void update(int a) {
        System.out.println(a);
    }

}
