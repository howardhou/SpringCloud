package com.example.hello.controller;

import com.example.hello.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
import java.util.logging.Logger;

@Api(description = "hello api")
@RestController
public class HelloController {
    private final Logger logger = Logger.getLogger(String.valueOf(getClass()));

    @Autowired
    private DiscoveryClient discoveryClient;

    @ApiOperation(value="测试方法", notes="注意：包括 不大于 3s 的 随机延迟，同时打印出 发现的服务数")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() throws InterruptedException {
        //ServiceInstance instance = client.getLocalServiceInstance();

        int sleepTime = new Random().nextInt(3000);
        logger.info("sleepTime: " + sleepTime);
        Thread.sleep(sleepTime);

        discoveryClient.getServices().forEach(id -> {
            discoveryClient.getInstances(id).forEach(instance -> {
                logger.info("index method, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
            });
        });

        return "Hello World";
    }

    /* 第6章使用， Feign */

    @ApiOperation(value = "测试方法1", notes = "直接返回参数")
    @RequestMapping(value = "hello1", method = RequestMethod.GET)
    public String hello(@RequestParam String name){
        return "Hello " + name;
    }

    @ApiOperation(value = "测试方法2", notes = "返回User Model")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户姓名", dataType = "String"),
            @ApiImplicitParam(name = "age", value = "年龄", dataType = "Integer")
    })
    @RequestMapping(value = "hello2", method = RequestMethod.GET)
    public User hello(@RequestHeader String name, @RequestHeader Integer age){
        return new User(name, age);
    }

    @RequestMapping(value = "hello3", method = RequestMethod.POST)
    public String hello(@RequestBody User user){
        return "hello " + user.getName() + ", " + user.getAge();
    }
}
