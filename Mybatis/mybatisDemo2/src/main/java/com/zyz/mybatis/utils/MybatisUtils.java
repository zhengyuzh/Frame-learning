package com.zyz.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @BelongsProject: Mybatis
 * @BelongsPackage: com.zyz.mybatis.utils
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-22  15:03
 * @Description: 数据库连接工具类  SqlSessionFactory -->SqlSession
 * @Version: 1.0
 */
public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;
    static {

        try {
            //使用Mybatis第一步：获取sqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * @description:
     * @author: zhengyuzhu
     * @date: 2023/11/22 15:01
     * @return: org.apache.ibatis.session.SqlSession
     * @description: 既然有了 SqlSessionFactory，顾名思义，我们可以从中获得 SqlSession 的实例。
     *               SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。
     *               你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
     **/
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession(true);
    }

}

