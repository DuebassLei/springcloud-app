package com.gaolei.feign.service;

import org.springframework.stereotype.Component;

/**
 * @Author: Gaolei
 * @Date: 2019/7/2 18:27
 */
@Component
public class TestServiceHystric implements TestService {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}
