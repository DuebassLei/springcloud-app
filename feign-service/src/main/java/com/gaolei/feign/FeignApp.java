package com.gaolei.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: Gaolei
 * @Date: 2019/7/2 17:10
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
/**
 * @EnableFeignClients 注解开启Feign的功能
 * */
public class FeignApp {
    public static void main(String[] args) {
        SpringApplication.run(FeignApp.class,args);
    }
}
