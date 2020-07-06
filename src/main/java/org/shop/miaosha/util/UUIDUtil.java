package org.shop.miaosha.util;

import org.junit.Test;

import java.util.UUID;

/**
 * token生成
 */
public class UUIDUtil {
    public  static String uuid(){
        return UUID.randomUUID().toString().replace("-","");
    }

    @Test
    public void gettoken(){
        String token = uuid();
        System.out.println(token);
    }
}
