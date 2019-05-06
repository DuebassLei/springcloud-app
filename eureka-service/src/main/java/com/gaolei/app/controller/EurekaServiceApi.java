package com.gaolei.app.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * @Author: Gaolei
 * @Date: 2019/5/6 12:45
 */
@RestController
public class EurekaServiceApi {
    private final Logger logger = LoggerFactory.getLogger(EurekaServiceApi.class);
    @Autowired
    private DiscoveryClient client;
    @RequestMapping(value = "/add",method=RequestMethod.GET)
    public Integer add(@RequestParam Integer a ,@RequestParam Integer b){
        Integer c = a+b;
        logger.info( "client services:"+client.getServices());
        return c;
    }

}
