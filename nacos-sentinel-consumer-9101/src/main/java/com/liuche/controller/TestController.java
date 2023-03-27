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

    @GetMapping("/test01")
    public String test01() {
        String str = "这是test01方法";
        return str;
    }
    @GetMapping("/test02")
    public String test02() {
        String str = "这是test02方法";
        return str;
    }

    @GetMapping("/flowThread")
    @SentinelResource(value = "flowThread",fallback = "sentinelTestFallBack",blockHandler = "sentinelTestBlockHandler")
    public String flowThread() throws InterruptedException {
        String str = "这是sentinel-test方法";
        Thread.sleep(2000);
        return str;
    }

    @GetMapping("/err")
    @SentinelResource(value = "err",fallback = "sentinelTestFallBack",blockHandler = "sentinelTestBlockHandler")
    public String err() throws InterruptedException {
        int i = 1/0;
        String str = "这是err方法";
        return str;
    }

}