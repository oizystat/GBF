package org.shop.miaosha.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Service
public class RedisPoolFactory {

    @Autowired
    RedisConfig redisConfig;

    @Bean
    public JedisPool JedisFactory() {
        if (redisConfig == null)System.out.println("config null");
        System.out.println(redisConfig.getHost());
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(redisConfig.getPoolMaxIdle());
        System.out.println("maxidle"+ redisConfig.getPoolMaxIdle());
        System.out.println(redisConfig.getPoolMaxIdle());
        poolConfig.setMaxTotal(redisConfig.getPoolMaxActive());
        System.out.println("cinfig maxtotal" + redisConfig.getPoolMaxActive());
        poolConfig.setMaxWaitMillis(redisConfig.getPoolMaxWait() * 1000);
        System.out.println(redisConfig.getPoolMaxWait());
        //配置完成后创造bean connecttimeout  sotimeout
        JedisPool j = new JedisPool(poolConfig,
                redisConfig.getHost(), redisConfig.getPort(), redisConfig.getTimeout() * 1000,
                redisConfig.getPassword(), 0);
        System.out.println("当前闲置数"+j.getNumIdle());
        System.out.println("当前可用实例"+j.getNumActive());
        return j;
    }
}
