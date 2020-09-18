package com.gaolei.feign.controller;

import com.gaolei.feign.service.TestService;

import com.gaolei.feign.service.TestServiceHystric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Gaolei
 * @Date: 2019/7/2 17:33
 */
@RestController
public class TestController {
    /**
     * feign调用eureka-service服务的接口
     * */
    @Autowired
    TestService testService;

    @GetMapping("hi")
    public  String sayHi(@RequestParam String name){
        return testService.sayHiFromClientOne(name);
    }

}
