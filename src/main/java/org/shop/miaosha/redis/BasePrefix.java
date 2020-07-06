package org.shop.miaosha.redis;

public abstract class BasePrefix implements KeyPrefix {

    private int expireSeconds;

    public BasePrefix(String prefix) {
        this(0, prefix);
    }

//    public BasePrefix(int expireSeconds) {
//        this.expireSeconds = expireSeconds;
//    }

    public int getExpireSeconds() {
        return expireSeconds;
    }

    public void setExpireSeconds(int expireSeconds) {
        this.expireSeconds = expireSeconds;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    private String prefix;
    //默认0代表永不过期
    public int expireSeconds() {
        return expireSeconds;
    }

    public BasePrefix(int expireSeconds, String prefix) {
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }

    public String getPrefix(){
        String className = getClass().getSimpleName();
        return  className +":"+ prefix;
    }
}
