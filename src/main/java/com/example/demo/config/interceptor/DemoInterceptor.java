package com.example.demo.config.interceptor;

import com.example.demo.entity.model.User;
import com.example.demo.exception.MyException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Component
public class DemoInterceptor implements HandlerInterceptor {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        //如果不是映射到方法直接通过
        if(!(handler instanceof HandlerMethod)){
            return true;
        } else {
            HandlerMethod h = (HandlerMethod) handler;
            AuthAccess authAccess = h.getMethodAnnotation(AuthAccess.class);
            if (authAccess != null) {
                return true;
            }
        }
        //校验token
        JwtUtils.checkUserToken(request);
        String userId = JwtUtils.getUserIdByJwtToken(request);
        User user = userMapper.getValidUser(userId);
        if (Objects.isNull(user)){
            throw new MyException("无效用户，请重新登录！","401");
        }
        return true;
    }
}
