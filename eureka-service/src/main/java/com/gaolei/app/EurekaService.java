package com.gaolei.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: Gaolei
 * @Date: 2019/5/6 12:34
 * @Desc: Eureka服务
 * <pre>
 *   @EnableDiscoveryClient 注解
 *  该注解能激活Eureka中的DiscoveryClient实现，
 *  才能实现Controller中对服务信息的输出。
 * </pre>
 * */
@EnableEurekaClient
@SpringBootApplication
public class EurekaService {
    public static void main(String[] args) {
        SpringApplication.run(EurekaService.class,args);
    }
}
