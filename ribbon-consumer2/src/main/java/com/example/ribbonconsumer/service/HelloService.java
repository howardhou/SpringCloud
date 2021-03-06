package com.example.ribbonconsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Service
public class HelloService {

    private final Logger logger = Logger.getLogger(String.valueOf(getClass()));

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback", commandKey = "m-helloServcie")
    public String helloServcie(){

        long start = System.currentTimeMillis();

        String result = restTemplate.getForEntity("http://hello-service/hello", String.class).getBody();

        long end = System.currentTimeMillis();

        logger.info("Speed Time : " +(end - start));

        return result;
    }

    public String helloFallback(Throwable e){
//        System.out.println(e.getMessage());
        System.out.println(e);
        return "error";
    }
}
