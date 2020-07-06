package org.shop.miaosha.redis;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.stereotype.Component;

/**
 * 这个自动注入真是个大坑 对前缀要求过高
 */
@Component
@ConfigurationProperties(prefix = "spring.redis")   //读取配置数据
@Data
public class RedisConfig {
    private String host;
    private int port;
    private int timeout;
    private String password;
    @Value("${spring.redis.jedis.pool.max-active}")
    private int poolMaxActive;
    @Value("${spring.redis.jedis.pool.max-idle}")
    private int poolMaxIdle;
    @Value("${spring.redis.jedis.pool.max-wait}")
    private int poolMaxWait;

}
