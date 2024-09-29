package com.example.demo.controller;

import com.example.demo.entity.model.User;
import com.example.demo.entity.result.ResultMessage;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserServiceImpl;
import com.example.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/login")
    public ResultMessage<String> home() {
        return ResultUtil.success("hello word!");
    }

    @RequestMapping("/getUser")
    public ResultMessage<User> getUser(@RequestParam("userId") String userId) {
        return userService.getUserById(userId);
    }
}
