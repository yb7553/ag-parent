package com.github.yanbin.uc.config;

import com.github.yanbin.common.handler.GlobalExceptionHandler;
import com.github.yanbin.uc.interceptor.ClientInterceptor;
import com.github.yanbin.uc.interceptor.JWTInterceptor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Bean
    GlobalExceptionHandler getGlobalExceptionHandler(){
        return new GlobalExceptionHandler();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getClientInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(getJWTInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    @Bean
    JWTInterceptor getJWTInterceptor(){
        return new JWTInterceptor();
    }

    @Bean
    ClientInterceptor getClientInterceptor(){
        return new ClientInterceptor();
    }
}
