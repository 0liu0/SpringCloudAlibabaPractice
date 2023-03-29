package com.liuche.service;

import com.liuche.config.OpenFeignConfig;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "nacos-service",fallback = FeignService9100FallBack.class) // 当这个接口里面的方法出现错误，就调用FeignService9100FallBack.class里面对应的方法
@LoadBalancerClient(name = "nacos-service",configuration = OpenFeignConfig.class)
public interface FeignService9100 {
    @GetMapping("/service-test/getport")
    String getPort();
    @GetMapping("/test")
    String test();
}
