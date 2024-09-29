package com.example.demo.entity.result;

import lombok.Data;
import java.io.Serializable;


@Data
public class ResultMessage<T> implements Serializable{
    /**
     * 返回code
     */
    private String code;
    /**
     * 返回状态
     */
    private String state;
    /**
     * 返回说明
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;
}
