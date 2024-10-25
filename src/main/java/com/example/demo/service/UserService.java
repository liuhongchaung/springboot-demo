package com.example.demo.service;

import com.example.demo.entity.model.User;
import com.example.demo.entity.result.ResultMessage;

import java.util.List;

public interface UserService {
    ResultMessage<User> login(User user);

    ResultMessage<User> getUserById(String userId);

    ResultMessage<List<User>> getAllUser(User user);
}
