package com.liuche;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // 启用nacos注册中心
public class NacosService9000 {
    public static void main(String[] args) {
        SpringApplication.run(NacosService9000.class,args);
    }
}