package com.rongzi.streamhello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.SendTo;

//实现对消息通道的绑定，建立一条输入通道绑定到 input Topic 上（RabbitMQ 中， 创建并绑定到 Exchange上）
//Sink 接口实现了 @Input 注解，绑定了名为 input 的通道
@EnableBinding(Sink.class)
public class SinkReceiver {

    private static Logger logger = LoggerFactory.getLogger(StreamHelloApplication.class);

    //注册为消息的监听器， 监听 input 通道的消息（RabbitMQ 中， 监听 Queue）
    @StreamListener(Sink.INPUT)
    public void receive(Object payload){
        logger.info("Received: " + payload);
    }
}
