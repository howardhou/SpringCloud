package com.rongzi.streamproductor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableBinding(SinkSender.class)
@RestController
public class ProductController {

    @Autowired
    SinkSender sinkSender;

    @RequestMapping("/product")
    public String product(){

        return sender();
    }

    public String sender(){

        sinkSender.output().send(MessageBuilder.withPayload("From SinkSender").build());
        return "send message : From SinkSender";
    }
}
