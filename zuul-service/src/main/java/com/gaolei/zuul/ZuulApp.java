package com.gaolei.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Author: Gaolei
 * @Date: 2019/7/2 19:28
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
/**
 * @EnableZuulProxy 开启Zuul路由和和过滤器
 * */
public class ZuulApp {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApp.class,args);
    }

}
