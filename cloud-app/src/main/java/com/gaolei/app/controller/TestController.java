package com.gaolei.app.controller;

import com.gaolei.app.anno.SysLogAnnotation;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author DuebassLei
 * @version 1.0
 * @date 2020/10/14 15:53
 */
@Api(tags = "测试")
@Controller
@RequestMapping(value = "/test/v1")
public class TestController {

    @SysLogAnnotation("切面测试")
    @GetMapping("/test")
    public String test(@RequestParam("name") String name){
        return name;
    }

}
