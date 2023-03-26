package com.liuche;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.liuche.service"})
public class NacosConsumer9100 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConsumer9100.class,args);
    }
}