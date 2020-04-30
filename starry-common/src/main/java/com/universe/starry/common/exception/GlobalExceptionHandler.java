package com.universe.starry.common.exception;

import com.universe.starry.common.enums.ResultEnum;
import com.universe.starry.common.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 匹配抛出自定义的基础异常类型
     * @param request
     * @param response
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = BasicException.class)
    @Order(value = 1)
    public Response basicExceptionHandler(HttpServletRequest request, HttpServletResponse response,
                                              BasicException exception) {
        log.error("BasicException occurred.", exception);
        return new Response(Boolean.FALSE, exception.getCode(), exception.getMessage());
    }

    /**
     * 默认处理异常方法
     * @param request
     * @param response
     * @param throwable
     * @return
     * @throws Exception
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Throwable.class)
    @Order(value = 99)
    public Response throwableHandler(HttpServletRequest request, HttpServletResponse response,
                                     Throwable throwable){
        log.error("Throwable occurred.", throwable);
        return new Response(false, ResultEnum.OPERATE_FAIL);
    }
}
