package com.rongzi.hello.web;

import com.rongzi.hello.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
import java.util.logging.Logger;

@RestController
public class HelloController {
    private final Logger logger = Logger.getLogger(String.valueOf(getClass()));

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() throws InterruptedException {
        //ServiceInstance instance = client.getLocalServiceInstance();

        int sleepTime = new Random().nextInt(3000);
        logger.info("sleepTime: " + sleepTime);
        Thread.sleep(sleepTime);

        discoveryClient.getServices().forEach(id -> {
            discoveryClient.getInstances(id).forEach(instance -> {
                logger.info("hello.HelloController.index(), host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
            });
        });

        return "Hello World";
    }

    /* 第6章使用， Feign */

    @RequestMapping(value = "hello1", method = RequestMethod.GET)
    public String hello(@RequestParam String name){
        return "Hello " + name;
    }

    @RequestMapping(value = "hello2", method = RequestMethod.GET)
    public User hello(@RequestHeader String name, @RequestHeader Integer age){
        return new User(name, age);
    }

    @RequestMapping(value = "hello3", method = RequestMethod.POST)
    public String hello(@RequestBody User user){
        return "hello " + user.getName() + ", " + user.getAge();
    }
}
