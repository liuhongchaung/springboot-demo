package com.example.demo.service.impl;

import com.example.demo.entity.constant.PublicConstant;
import com.example.demo.entity.model.User;
import com.example.demo.entity.result.ResultMessage;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.example.demo.utils.JwtUtils;
import com.example.demo.utils.ResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultMessage<User> login(User user){
        if (StringUtils.isEmpty(user.getLoginName()) ||  StringUtils.isEmpty(user.getPassword())){
            return ResultUtil.error("用户名或密码不能为空");
        }
        User loginUser = userMapper.login(user.getLoginName(),user.getPassword());
        if (Objects.isNull(loginUser)){
            return ResultUtil.error("用户名或密码错误");
        }
        if (PublicConstant.UNVALID.equals(loginUser.getValid())){
            return ResultUtil.error("此用户已禁用，请联系管理员");
        }
        if (!user.getRole().equals(loginUser.getRole())){
            return ResultUtil.error("此用户为“"+PublicConstant.roleMap.get(loginUser.getRole())+"”权限");
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
