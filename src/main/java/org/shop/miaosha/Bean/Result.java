package org.shop.miaosha.Bean;

import lombok.Data;

@Data
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    private Result(T data){
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }
    private Result(int code, String msg){
        this.code = code;
        this.msg = msg;
        this.data = null;
    }

    public static <T> Result<T> success(T data){
        return new Result<>(data);
    }
    public static <T> Result<T> error(int code, String msg){
        return new Result<>(code, msg);
    }
}
