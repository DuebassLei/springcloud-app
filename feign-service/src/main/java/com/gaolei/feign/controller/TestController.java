package com.gaolei.feign.controller;

import com.gaolei.feign.service.TestService;

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
    @Autowired
    TestService testService;
    @GetMapping("hi")
    public  String sayHi(@RequestParam String name){
        return testService.sayHiFromClientOne(name);
    }
}
