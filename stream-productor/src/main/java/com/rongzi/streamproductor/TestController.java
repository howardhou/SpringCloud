package com.rongzi.streamproductor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//绑定接口
@EnableBinding(SinkSender.class)
@RestController
public class TestController {

    @RequestMapping("/test1")
    public String test1(){

        return sender1();
    }

    @RequestMapping("/test2")
    public String test2(){

        return sender2();
    }

    //注入绑定接口
    @Autowired
    SinkSender sinkSender;

    public String sender1(){

        sinkSender.output().send(MessageBuilder.withPayload("From SinkSender").build());
        return "send message : From SinkSender";
    }

    //注入消息通道
    @Autowired
    MessageChannel input;

    public String sender2(){

        input.send(MessageBuilder.withPayload("From MessageChannel").build());
        return "send message : From MessageChannel";
    }
}
