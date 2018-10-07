package com.github.yanbin.uc.interceptor;

import com.github.yanbin.common.context.BaseContextHandler;
import com.github.yanbin.common.util.jwt.IJWTInfo;
import com.github.yanbin.uc.jwt.JWTUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class JWTInterceptor extends HandlerInterceptorAdapter {
    private Logger logger= LoggerFactory.getLogger(JWTInterceptor.class);
    @Value("${jwt.token-header}")
    private  String tokenHeader;
    @Autowired
    private JWTUtil jwtUtil;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("jwt interceptor.....");
        String token = request.getHeader(tokenHeader);
        IJWTInfo infoFromToken = jwtUtil.getInfoFromToken(token);
        BaseContextHandler.setUsername(infoFromToken.getUniquename());
        BaseContextHandler.setName(infoFromToken.getName());
        BaseContextHandler.setUserID(infoFromToken.getId());
        return super.preHandle(request, response, handler);
    }
}
