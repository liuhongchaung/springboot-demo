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

    private String role;

    private String valid;

    private Date createTime;

    private String token;

}