package com.example.demo.entity.constant;

import java.util.HashMap;
import java.util.Map;

public class PublicConstant {

    /**
     * 成功
     */
    public final static String STATE_SUCCESS = "success";
    /**
     * 失败
     */
    public final static String STATE_ERROR = "error";


    /**
     * 成功code
     */
    public final static String CODE_SUCCESS = "200";
    /**
     * 失败code
     */
    public final static String CODE_ERROR = "500";


    /**
     * 成功默认消息
     */
    public final static String MESSAGE_SUCCESS = "操作成功";
    /**
     * 失败默认消息
     */
    public final static String MESSAGE_ERROR = "操作失败";


    /**
     * 有效
     */
    public final static String VALID = "1";

    /**
     * 无效
     */
    public final static String UNVALID = "2";


    public final static Map<String,String> roleMap = new HashMap();
    static {
        roleMap.put("1","管理员");
        roleMap.put("2","普通用户");
    }
    /**
     * 管理员-1,普通用户-2
     */
    public final static String ROLE_1 = "1";
    public final static String ROLE_2 = "2";



}
