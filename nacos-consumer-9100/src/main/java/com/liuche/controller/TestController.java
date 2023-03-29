package com.liuche.controller;

import com.liuche.service.FeignService9100;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer-test")
@RefreshScope
public class TestController {
    @Value("${person.name}")
    private String name;
    @Autowired
    private FeignService9100 feignService;

    @GetMapping("/get-server-port")
    public String getServerPort() {
        return "9100" + feignService.getPort();
    }

    @GetMapping("/get-person-name")
    public String getPersonName() {
        return "当前consumer的名字：" + name;
    }

}
