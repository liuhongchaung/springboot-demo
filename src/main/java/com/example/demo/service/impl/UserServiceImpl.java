package com.example.demo.service.impl;

import com.example.demo.entity.model.User;
import com.example.demo.entity.result.ResultMessage;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.example.demo.utils.JwtUtils;
import com.example.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public ResultMessage<User> login(String loginName , String password){
        User loginUser = userMapper.login(loginName, password);
        if (Objects.isNull(loginUser)){
            return ResultUtil.error("用户名或密码错误");
        }
        loginUser.setToken(JwtUtils.getJwtToken(loginUser));
        return ResultUtil.success(loginUser,"登录成功");
    }

    @Override
    public ResultMessage<User> getUserById(String userId){
        User user = userMapper.selectByPrimaryKey(userId);
        if (Objects.isNull(user)){
            return ResultUtil.error("用户不存在");
        }
        return ResultUtil.success(user);
    }
}
