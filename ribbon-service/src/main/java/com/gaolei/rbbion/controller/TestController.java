package com.gaolei.rbbion.controller;

import com.gaolei.rbbion.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Gaolei
 * @Date: 2019/7/2 16:18
 */
@RestController
public class TestController {

    @Autowired
    TestService testService;
    @RequestMapping(value = "hi")
    public String hi(@RequestParam String name){
        return testService.hiService(name);
    }
    /**
     *浏览器访问 http://localhost:8763/hi?name=gaolei
     * 调用的是8762端口的eureka服务实例，若为多实例，则调用不同的实例
     */

}
