package com.example.demo.service;

import com.example.demo.entity.model.User;
import com.example.demo.entity.result.ResultMessage;

public interface UserService {
    ResultMessage<User> login(User user);

    ResultMessage<User> getUserById(String userId);
}
