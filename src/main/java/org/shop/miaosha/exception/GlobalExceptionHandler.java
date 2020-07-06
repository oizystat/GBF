package org.shop.miaosha.exception;

import org.shop.miaosha.Bean.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器  拦截异常 分批处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public void exceptionHandler(HttpServletRequest httpServletRequest, Exception e){
        if ( e instanceof java.lang.NullPointerException){
            System.out.println("sql error");
        }
    }
}
