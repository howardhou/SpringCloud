package com.rongzi.feignconsumer.controller;

import com.rongzi.feignconsumer.service.RefactorHelloService;
import com.rongzi.helloserviceapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    RefactorHelloService refactorHelloService;

    @RequestMapping(value = "/feign-consumer3",method = RequestMethod.GET)
    public String helloConsumer3(){
        StringBuilder sb = new StringBuilder();

        sb.append(refactorHelloService.hello("Hou Howard")).append("\n");

        sb.append(refactorHelloService.hello("HH",28)).append("\n");

        sb.append(refactorHelloService.hello(new User("LN",36))).append("\n");

        return sb.toString();
    }
}