package com.example.demo.exception;

/**
 * 描述 统一异常
 */
public class MyException extends RuntimeException  {

    private final String code;
    private final String message;

    public MyException(String message ,String code){

        this.code=code;
        this.message=message;

    }
    public MyException(String message){

        this.code="500";
        this.message=message;

    }
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
