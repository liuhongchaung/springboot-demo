package com.example.demo.service;

import com.example.demo.entity.dto.SelectUserDto;
import com.example.demo.entity.model.User;
import com.example.demo.entity.result.ResultMessage;
import com.github.pagehelper.PageInfo;

public interface UserService {
    ResultMessage<User> login(User user);

    ResultMessage<User> getUserById(String userId);

    ResultMessage<PageInfo<User>> getAllUser(SelectUserDto user);

    ResultMessage<String> addUser(User user);

    ResultMessage<String> deleteUser(String userId);
}
