package com.gaolei.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: Gaolei
 * @Date: 2019/7/2 17:31
 * @Desc: feign调用
 * <pre>
 *     正常调用:TestService 的 sayHiFromClientOne()方法
 *     网络不通失败调用： TestServiceHystric的sayHiFromClientOne()方法
 * </pre>
 */
@FeignClient(value = "eureka-service",fallback = TestServiceHystric.class)
public interface TestService {
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
