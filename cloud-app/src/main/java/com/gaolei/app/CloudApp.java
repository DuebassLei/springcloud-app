package com.gaolei.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author DuebassLei
 * @Date 2020/9/18 17:47
 * @Version 1.0
 * @Description study app demo
 */

@EnableEurekaClient
@SpringBootApplication
public class CloudApp {
    public static void main(String[] args) {
        SpringApplication.run(CloudApp.class,args);
    }
}
