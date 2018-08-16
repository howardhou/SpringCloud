package com.rongzi.feignconsumer.service;

import com.rongzi.helloserviceapi.service.HelloService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient("hello-service")
public interface RefactorHelloService extends HelloService {

}
