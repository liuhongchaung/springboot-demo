package com.example.demo.entity.dto;

import lombok.Data;

@Data
public class SelectUserDto {

    private String loginName;

    private String userName;

    //每页数量
    private int pageSize;

    //页码
    private int pageNum;

}
