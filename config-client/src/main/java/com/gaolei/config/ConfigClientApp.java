package com.gaolei.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author: Gaolei
 * @Date: 2019/7/5 12:20
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ConfigClientApp {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApp.class,args);
    }

    @Value("${order.name}")
    String orderName;

    @RequestMapping("/test")
    public String test() {
        return "client ====>>> " + orderName;
    }
}
