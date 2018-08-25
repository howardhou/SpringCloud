package com.rongzi.trace1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class TraceController {
    private final Logger logger = LoggerFactory.getLogger(TraceController.class);

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/trace1")
    public String trace(){
        logger.info("======call trace 1 =======");

        String result = restTemplate.getForEntity("http://trace-2/trace2", String.class).getBody();

        return result;
    }
}
