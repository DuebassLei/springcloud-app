package com.gaolei.rbbion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Gaolei
 * @Date: 2019/7/2 16:11
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
/**
 * @EnableHystrix 开启Hystrix
 * @EnableHystrixDashboard 开启hystrixDashboard
 * */
@EnableHystrixDashboard
public class RibbonApp {
    public static void main(String[] args) {
        SpringApplication.run(RibbonApp.class,args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return  new RestTemplate();
    }
}
