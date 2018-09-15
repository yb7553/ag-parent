package com.github.yanbin.uc.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserRest {
    @Value("${language.en:你好，世界}")
    private String hello;
    @RequestMapping("/{id}")
    public String getUserInfo(@PathVariable String id){
        return hello;
    }
}
