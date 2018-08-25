package com.rongzi.trace2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class Trace2Application {

    public static void main(String[] args) {
        SpringApplication.run(Trace2Application.class, args);
    }


    private final Logger logger = Logger.getLogger(getClass().toString());

    @RequestMapping("/trace2")
    public String trace(){

        logger.info("==== < call trace 2 > ====");
        return "Trace 2";
    }
}
