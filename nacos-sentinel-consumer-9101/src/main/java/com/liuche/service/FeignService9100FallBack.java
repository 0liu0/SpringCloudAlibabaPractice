package com.liuche.service;

import org.springframework.stereotype.Component;

@Component
public class FeignService9100FallBack implements FeignService9100{
    @Override
    public String getPort() {
        return "getPort降级了！！！";
    }

    @Override
    public String test() {
        return "test降级了！！！";
    }
}
