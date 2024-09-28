package com.example.demo.config.interceptor;

import com.example.demo.utils.JwtUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class DemoInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //检查是否有token
        if (JwtUtils.checkToken(request)){
            response.setStatus(500);
            System.out.println("请登录");

            return false;
        }
        System.out.println("通过");
        return true;
    }
}
