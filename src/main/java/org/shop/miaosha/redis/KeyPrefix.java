package org.shop.miaosha.redis;

public interface KeyPrefix {

    int expireSeconds();

    String getPrefix();
}
