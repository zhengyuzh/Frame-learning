package com.zyz.test;

import com.zyz.jedis.util.JedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * @BelongsProject: Redis
 * @BelongsPackage: com.zyz.test
 * @Author: zhengyuzhu
 * @CreateTime: 2024-06-23  17:25
 * @Description: 测试JedisTest
 * @Version: 1.0
 */
public class JedisTest {
    private Jedis jedis;

    @BeforeEach
    void setUp(){
        // 1.建立连接
        jedis = new Jedis("192.168.202.211",6379);
        // 2.设置密码
        jedis.auth("123456");
        // 3.选择库
        jedis.select(0);

    }

    /**
     * @description: 1、测试String类型
     * @author: zhengyuzhu
     * @date: 2024/6/23 17:47
     **/
    @Test
    void testString(){

        // 插入数据，方法名称就是redis命令名称，非常简单
        String result = jedis.set("name","jack");
        System.out.println("result = " + result);

        // 获取数据
        String name = jedis.get("name");
        System.out.println("name = " + name);

        /**
         * 测试结果：
         *
         * result = OK
         * name = jack
         **/

    }

    /**
     * @description: 测试Hash类型
     * @author: zhengyuzhu
     * @date: 2024/6/23 17:48
     **/
    @Test
    void testHash(){
        //设置值
        // jedis.hset("user:1","name","zhangsan");

        //使用连接池
        jedis = JedisConnectionFactory.getJedis();
        jedis.hset("user:1","age","18");

        //取值
        Map<String, String> map = jedis.hgetAll("user:1");
        System.out.println(map);


        /**
         * 测试结果：
         *
         * {name=zhangsan, age=18}
         **/

    }

    @AfterEach
    void tearDown(){
        // 释放资源
        if(jedis != null){
            jedis.close();
        }
    }


}
