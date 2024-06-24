package com.zyz.jedis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @BelongsProject: Redis
 * @BelongsPackage: com.zyz.jedis.util
 * @Author: zhengyuzhu
 * @CreateTime: 2024-06-24  22:10
 * @Description: TODO
 * @Version: 1.0
 */
public class JedisConnectionFactory {

    private static  final JedisPool JEDIS_POOL;


    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

        //最大连接
        jedisPoolConfig.setMaxTotal(8);

        //最大空闲连接
        jedisPoolConfig.setMaxIdle(8);

        //最小空闲连接
        jedisPoolConfig.setMinIdle(0);

        //设置最长等待时间  ms
        jedisPoolConfig.setMaxWaitMillis(1000);
        JEDIS_POOL = new JedisPool(jedisPoolConfig,"192.168.202.211",6379,1000,"123456");
    }

    /**
     * @description: 获取Jedis对象
     * @author: zhengyuzhu
     * @date: 2024/6/24 22:17
     * @return: redis.clients.jedis.Jedis
     **/
    public static Jedis getJedis(){
        return JEDIS_POOL.getResource();
    }
}
