package org.shop.miaosha.util;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {
    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }

    //防止md5被拦截解密 可以自己对源数据进行编码后再加密 可以把编码用的串存入数据库
}
