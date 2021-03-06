package com.rongzi.helloserviceapi.service;

import com.rongzi.helloserviceapi.model.User;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/refactor")
public interface HelloService {

    @RequestMapping(value = "hello1", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

    @RequestMapping(value = "hello2", method = RequestMethod.GET)
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "hello3", method = RequestMethod.POST)
    String hello(@RequestBody User user);
}
