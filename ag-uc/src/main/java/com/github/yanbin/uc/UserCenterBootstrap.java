package com.github.yanbin.uc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@MapperScan("com.github.yanbin.uc.mapper")
@EnableTransactionManagement
public class UserCenterBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(UserCenterBootstrap.class,args);
    }
}
