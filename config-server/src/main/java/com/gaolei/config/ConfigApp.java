package com.gaolei.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author: Gaolei
 * @Date: 2019/7/3 15:39
 */
@SpringBootApplication
@EnableConfigServer //开启配置中心服务
public class ConfigApp {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApp.class,args);
    }
}
