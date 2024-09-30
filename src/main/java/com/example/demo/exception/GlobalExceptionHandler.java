package com.example.demo.exception;

import com.example.demo.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 描述 处理统一异常的Handler
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handlerException ( Exception e){
        log.error("Default Exception",e);
        return ResultUtil.error("系统异常，请联系管理员");
    }

    @ExceptionHandler(MyException.class)
    @ResponseBody
    public Object handlerMyException (MyException e){
        log.error("MyException Exception", e );
        return ResultUtil.error(e.getMessage(),e.getCode());
    }



}
