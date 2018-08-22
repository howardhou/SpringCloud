package com.rongzi.configclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController {

    @Value("${form}")
    private String from;

    @Autowired
    private Environment env;

    @RequestMapping("/from")
    public String from() {

        String str = env.getProperty("from", "undefined");

        return this.from +" "+ str;
    }
}
