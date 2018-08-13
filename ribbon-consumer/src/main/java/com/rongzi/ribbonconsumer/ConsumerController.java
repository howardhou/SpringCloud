package com.rongzi.ribbonconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    //@Autowired
    //RestTemplate restTemplate;

    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/ribbon-consumer")
    public String helloConsumer(){
        return helloService.helloServcie();
        //return restTemplate.getForEntity("http://hello-service/hello", String.class).getBody();
    }
}
