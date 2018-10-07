package com.github.yanbin.auth.util;

import com.github.yanbin.common.util.jwt.IJWTInfo;
import com.github.yanbin.common.util.jwt.JWTHelper;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
public class JWTUtil {

    @Value("${jwt.expire}")
    private int expire;

    @Value("${jwt.pri-key.path}")
    private String priKeyPath;

    @Value("${jwt.pub-key.path}")
    private String pubKeyPath;


    public String generateToken(IJWTInfo jwtInfo) throws Exception {
        return JWTHelper.generateToken(jwtInfo, priKeyPath,expire);
    }

    public IJWTInfo getInfoFromToken(String token) throws Exception {
        return JWTHelper.getInfoFromToken(token, pubKeyPath);
    }
}
