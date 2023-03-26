package com.liuche.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service-test")
public class TestService {
    @Value("${server.port}")
    private String port;

    @GetMapping("/getport")
    public String getPort() {
        return "我是服务提供者，端口号为：" + port;
    }
}
