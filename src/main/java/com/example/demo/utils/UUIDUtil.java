package com.example.demo.utils;

import java.util.UUID;

public class UUIDUtil {

    /**
     * 生成32位UUID，返回类型为String（32）
     */
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        //去掉“-”符号
        return uuid.replaceAll("-", "");
    }


}


