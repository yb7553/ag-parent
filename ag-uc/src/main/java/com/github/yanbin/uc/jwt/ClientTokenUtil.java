package com.github.yanbin.uc.jwt;

import com.github.yanbin.common.util.jwt.IJWTInfo;
import com.github.yanbin.common.util.jwt.JWTHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientTokenUtil {
    private Logger logger = LoggerFactory.getLogger(ClientTokenUtil.class);



    @Value("${client.pub-key.path}")
    private String pubKeyPath;


    public IJWTInfo getInfoFromToken(String token) throws Exception {
        return JWTHelper.getInfoFromToken(token, pubKeyPath);
    }
}
