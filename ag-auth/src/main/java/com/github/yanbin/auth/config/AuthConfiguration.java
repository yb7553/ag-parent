package com.github.yanbin.auth.config;

import com.github.yanbin.common.handler.GlobalExceptionHandler;
import org.springframework.context.annotation.Bean;

public class AuthConfiguration {
    @Bean
    public GlobalExceptionHandler getGlobalExceptionHandler(){
        return new GlobalExceptionHandler();
    }
}
