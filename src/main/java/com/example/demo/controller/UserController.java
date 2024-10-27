package com.example.demo.controller;

import com.example.demo.entity.dto.SelectUserDto;
import com.example.demo.entity.model.User;
import com.example.demo.entity.result.ResultMessage;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserServiceImpl;
import com.example.demo.utils.ResultUtil;
import com.github.pagehelper.PageInfo;
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
    public ResultMessage<PageInfo<User>> getAllUser(@RequestBody SelectUserDto userDto) {
        return userService.getAllUser(userDto);
    }

    @PostMapping("/addUser")
    @ApiOperation("增加、修改用户")
    public ResultMessage<String> addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/deleteUser")
    @ApiOperation("删除用户")
    public ResultMessage<String> deleteUser(@RequestParam("userId") String userId) {
        return userService.deleteUser(userId);
    }
}
