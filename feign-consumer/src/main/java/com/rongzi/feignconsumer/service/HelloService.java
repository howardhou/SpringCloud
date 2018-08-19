package com.rongzi.feignconsumer.service;

import com.rongzi.feignconsumer.FullLogConfigration;
import com.rongzi.feignconsumer.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "hello-service", configuration = FullLogConfigration.class)
@Component
public interface HelloService {

    @RequestMapping("hello")
    String hello();

    @RequestMapping(value = "hello1", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

    @RequestMapping(value = "hello2", method = RequestMethod.GET)
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "hello3", method = RequestMethod.POST)
    String hello(@RequestBody User user);
}
