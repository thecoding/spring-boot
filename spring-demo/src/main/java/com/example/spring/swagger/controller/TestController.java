package com.example.spring.swagger.controller;

import com.example.swagger.stater.annotation.ApiVersion;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mirko
 * @Description
 * @createTime 2021年07月01日 00:49:00
 */
@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping("success")
    @ApiVersion(group = "version_v1")
    public String swaggerTest(){
        return "success";
    }

    @RequestMapping("successV2")
    @ApiVersion(group = "version_v2")
    public String v2Test(){
        return "v2";
    }

    @RequestMapping("defaultVersion")
    public String defaultVersion(){
        return "default";
    }
}
