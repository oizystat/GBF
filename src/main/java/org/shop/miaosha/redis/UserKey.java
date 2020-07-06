package org.shop.miaosha.redis;

public class UserKey extends BasePrefix{
    //封装
//    private UserKey(int expireSeconds, String prefix) {
//        super(expireSeconds, prefix);
//    }

    private UserKey(String prefix) {
        super(prefix);
    }
    public static UserKey getById = new UserKey("id");
}
