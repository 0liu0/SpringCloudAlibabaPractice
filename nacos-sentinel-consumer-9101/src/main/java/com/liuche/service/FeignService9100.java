package com.liuche.service;

import com.liuche.config.OpenFeignConfig;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "nacos-service")
@LoadBalancerClient(name = "nacos-service",configuration = OpenFeignConfig.class)
public interface FeignService9100 {
    @GetMapping("/service-test/getport")
    String getPort();
}
