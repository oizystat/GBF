package org.shop.miaosha.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Service
public class RedisService {
    //    JedisPool jedisPool = null;//连接池   当前非容器模式
    @Autowired
    JedisPool jd;
    @Autowired
    RedisConfig redisConfig;

    public <T>boolean set(String key, T value) {
        Jedis jedis = null;
        try {
            jedis = jd.getResource();
            String str = beanToString(value);
            jedis.set(key, str);
            return true;
        } finally {
            returnToPool(jedis);
        }
    }

    public <T> T get(String key, Class<T> clazz) {
        Jedis js = null;
        try {
            js = jd.getResource();
            if (js == null)System.out.println("jedis null");
            String value = js.get(key);
            T t = stringToBean(value, clazz);
            return t;
        } finally {
            returnToPool(js);
        }
    }

    private <T> T stringToBean(String str, Class<T> tClass) {
        if (str == null || str.length() == 0) return null;
        if (tClass == Integer.class) return (T) Integer.valueOf(str);
        if (tClass == String.class) return (T) str;
        if (tClass == Long.class) return (T) Long.valueOf(str);
        return JSON.toJavaObject(JSON.parseObject(str), tClass);
    }

    private <T> String beanToString(T value) {
        if (value == null) return null;
        Class<?> clazz = value.getClass();
        if (clazz == Integer.class) return "" + value;
        if (clazz == String.class) return (String) value;
        if (clazz == Long.class) return "" + value;
        return JSON.toJSONString(value);
    }

    private void returnToPool(Jedis jedis) {
        if (jedis != null) {
            jedis.close();// 返回idao连接池
        }
    }
//    @Bean  //注意  此时构成了循环依赖  该服务需要注入该bean  该bean需要调用该服务
//    public JedisPool  JedisFactory(){
//        JedisPoolConfig poolConfig = new JedisPoolConfig();
//        poolConfig.setMaxIdle(redisConfig.getPoolMaxIdle());
//        poolConfig.setMaxTotal(redisConfig.getPoolMaxActive());
//        poolConfig.setMaxWaitMillis(redisConfig.getPoolMaxWait() * 1000);
//        //配置完成后创造bean connecttimeout  sotimeout
//        JedisPool jedisPool = new JedisPool(poolConfig,
//                redisConfig.getHost(), redisConfig.getPort(), redisConfig.getTimeout() * 1000,
//                redisConfig.getPassword(), 0);
//        return jedisPool;
//}
}
