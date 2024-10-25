package com.example.demo.controller;

import com.example.demo.entity.model.User;
import com.example.demo.entity.result.ResultMessage;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserServiceImpl;
import com.example.demo.utils.ResultUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ApiOperation("用户controller")
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/login")
    @ApiOperation("用户登录")
    public ResultMessage<User> login(@RequestBody User user) {
        return userService.login(user);
    }

    @GetMapping("/getUser")
    @ApiOperation("Id查询用户信息")
    public ResultMessage<User> getUser(@RequestParam("userId") String userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/getAllUser")
    @ApiOperation("查询全部用户信息")
    public ResultMessage<List<User>> getAllUser(@RequestBody User user) {
        return userService.getAllUser(user);
    }
}
