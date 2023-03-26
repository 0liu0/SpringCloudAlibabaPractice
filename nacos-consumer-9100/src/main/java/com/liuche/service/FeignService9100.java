package com.liuche.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "nacos-service")
public interface FeignService9100 {
    @GetMapping("/service-test/getport")
    String getPort();
}
