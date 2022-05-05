package com.petcelsius.api.exception;


import com.petcelsius.api.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : 自定义异常处理器，这个是全局的controller层的异常
 */
/**
 * 自定义异常处理器，这个是全局的,controller层的异常
 */
@Slf4j
@RestControllerAdvice
public class SelfExceptionHandler {

    /**
     * 请求方法不正确的时候触发
     * @param exception
     * @return
     */
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public R requestMethodNotAllowed(HttpRequestMethodNotSupportedException exception){
        log.error("异常消息: {}, 异常类型: {}", exception.getMessage(), exception.getClass());
        return R.error(HttpStatus.SC_METHOD_NOT_ALLOWED, "这个接口不能使用" + exception.getMethod() + "方法请求");
    }

    /**
     * 通用异常处理器
     * @param exception
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public R commonExceptionHandler(Exception exception){
        log.error("异常消息: {}, 异常类型: {}", exception.getMessage(), exception.getClass());
        return R.error("服务器内部异常");
    }
}
