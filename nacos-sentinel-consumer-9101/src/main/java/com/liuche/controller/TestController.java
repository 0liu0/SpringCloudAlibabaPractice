package com.liuche.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
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
        return feignService.getPort();
    }

    @GetMapping("/get-person-name")
    public String getPersonName() {
        return "当前consumer的名字：" + name;
    }

    @GetMapping("/sentinel-test")
    @SentinelResource(value = "sentinelTest",fallback = "sentinelTestFallBack",blockHandler = "sentinelTestBlockHandler")
    public String sentinelTest() throws InterruptedException {
        String str = "这是sentinel-test方法";
        return str;
    }
    public String sentinelTestBlockHandler(BlockException e) {
        return "这是sentinelTestBlockHandler";
    }

    public String sentinelTestFallBack() {
        return "这是sentinelTestFallBack";
    }
}