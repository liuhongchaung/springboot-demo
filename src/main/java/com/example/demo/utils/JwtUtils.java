package com.example.demo.utils;

import com.example.demo.entity.model.User;
import com.example.demo.exception.MyException;
import com.example.demo.mapper.UserMapper;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Objects;


public class JwtUtils {

    /**
     * 两个常量： 过期时间；秘钥
     */
    public static final long EXPIRE = 1000*60*60*24;
    public static final String SECRET = "DfsGs8dfF58jj85sdf2ASef5ef8g2";

    /**
     * 生成token
     * @param user
     * @return
     */
    public static String getJwtToken(User user){
        String JwtToken = Jwts.builder()
                //JWT头信息
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS2256")
                //设置分类；设置过期时间 一个当前时间，一个加上设置的过期时间常量
                .setSubject("demo-user")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                //设置token主体信息，存储用户信息
                .claim("id", user.getId())
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
        return JwtToken;
    }

    /**
     * 校验token
     * @Param request
     */
    public static boolean checkToken(HttpServletRequest request){
        try {
            String token = request.getHeader("token");
            if (StringUtils.isEmpty(token)){
                return false;
            }
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    /**
     * 校验token
     * @Param request
     */
    public static void checkUserToken(HttpServletRequest request){
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)){
            throw new MyException("未登录，请先登录！","401");
        }
        try {
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
        }catch (Exception e){
            throw new MyException("登录失效，请重新登录！","401");
        }
    }

    /**
     * 根据request获取用户id
     * @Param request
     */
    public static String getUserIdByJwtToken(HttpServletRequest request){
        String token = request.getHeader("token");
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
        Claims body = claimsJws.getBody();
        return (String) body.get("id");
    }




}

