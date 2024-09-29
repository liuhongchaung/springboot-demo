package com.example.demo.config.interceptor;

import com.example.demo.utils.JwtUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class DemoInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");

        if (StringUtils.isEmpty(token)){
            System.out.println("无token，请登录！");
            throw new RuntimeException("无token，请登录！");
        }
        //检查是否有token
        /*if (JwtUtils.checkToken(request)){
            response.setStatus(500);
            System.out.println("请登录");

            return false;
        }*/
        System.out.println("通过");
        return true;
    }
}
