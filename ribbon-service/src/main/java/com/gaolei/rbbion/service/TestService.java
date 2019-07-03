package com.gaolei.rbbion.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Gaolei
 * @Date: 2019/7/2 16:18
 */
@Service
public class TestService {

    @Autowired
    RestTemplate restTemplate;
    /**
     * restTemplate.getForObject("http://eureka-service/hi?name="+name,String.class)方法时，
     * 已经做了负载均衡，访问了不同的端口的服务实例。
     * */
    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://eureka-service/hi?name="+name,String.class);
    }
    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}
