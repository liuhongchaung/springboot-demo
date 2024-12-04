package com.example.demo.service.impl;

import com.example.demo.entity.dto.SelectUserDto;
import com.example.demo.entity.constant.PublicConstant;
import com.example.demo.entity.model.User;
import com.example.demo.entity.result.ResultMessage;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.example.demo.utils.JwtUtils;
import com.example.demo.utils.ResultUtil;
import com.example.demo.utils.UUIDUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
//ceshi
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

    @Override
    public ResultMessage<PageInfo<User>> getAllUser(SelectUserDto userDto){
        PageHelper.startPage(userDto.getPageNum(),userDto.getPageSize());
        List<User> allUser = userMapper.getAllUser(userDto);
        PageInfo<User> page = new PageInfo(allUser);
        return ResultUtil.success(page);
    }

    @Override
    public ResultMessage<String> addUser(User user) {
        String id = user.getId();
        //校验不能添加、修改成重复账号
        String loginName = user.getLoginName();
        User userOne = userMapper.selectUserByLoginName(loginName);
        if (Objects.nonNull(userOne) && !userOne.getId().equals(id)){
            return ResultUtil.error("账号已存在");
        }
        //修改
        if (StringUtils.isNotBlank(id)){
            userMapper.updateByPrimaryKeySelective(user);
        }
        //增加
        else{
            user.setId(UUIDUtil.getUUID());
            user.setCreateTime(new Date());
            user.setValid("1");
            userMapper.insertSelective(user);
        }
        return ResultUtil.success(StringUtils.isNotBlank(id)?"修改成功":"添加成功");
    }

    @Override
    public ResultMessage<String> deleteUser(String userId) {
        userMapper.deleteByPrimaryKey(userId);
        return ResultUtil.success("删除成功");
    }
}
