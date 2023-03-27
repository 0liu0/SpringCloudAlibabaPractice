package com.liuche;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.liuche.service"})
public class NacosSentinelConsumer9101 {
    public static void main(String[] args) {
        SpringApplication.run(NacosSentinelConsumer9101.class,args);
    }
}