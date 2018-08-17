package com.rongzi.feignconsumer.service;

import com.rongzi.helloserviceapi.service.HelloService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(name = "hello-service", fallback = RefactorFallback.class)
public interface RefactorHelloService extends HelloService {

}
