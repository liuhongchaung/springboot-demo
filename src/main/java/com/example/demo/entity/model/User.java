package com.example.demo.entity.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String id;

    private String loginName;

    private String password;

    private String userName;

    private String phone;

    /**
     * 权限，1管理员，2普通用户
     */
    private String role;

    /**
     * 是否有效，1-有效，2-无效
     */
    private String valid;

    private Date createTime;

    private String token;

}
