package com.example.demo.mapper;

import com.example.demo.entity.dto.SelectUserDto;
import com.example.demo.entity.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User login(@Param("loginName")String loginName, @Param("password")String password);

    User getValidUser(String id);

    User selectUserByLoginName(@Param("loginName")String loginName);

    List<User> getAllUser(SelectUserDto userDto);

}
