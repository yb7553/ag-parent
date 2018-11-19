package com.github.yanbin.gate.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/env")
@RefreshScope// 使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候
public class EnvController {
    @Value("${env}")
    private String env;

    @GetMapping("/print")
    public String print(){
        return env;
    }
}
