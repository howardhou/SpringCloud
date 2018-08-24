package com.rongzi.streamhello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.messaging.handler.annotation.SendTo;

import java.text.SimpleDateFormat;
import java.util.Date;

//实现对消息通道的绑定，建立一条输入通道绑定到 input Topic 上（RabbitMQ 中， 创建并绑定到 Exchange上）
//Sink 接口实现了 @Input 注解，绑定了名为 input 的通道
@EnableBinding({Sink.class, Input2Receiver.class, Input3Receiver.class})
public class SinkReceiver {

    private static Logger logger = LoggerFactory.getLogger(StreamHelloApplication.class);

    // 使用 Spring Cloud Stream 注解
    // 注册为消息的监听器，StreamListener 内部还实现了消息转换功能
    // 监听 input 通道的消息（在RabbitMQ 中就是监听 Queue）
    @StreamListener(Sink.INPUT)
    public void receive(String payload){
        logger.info("Received: " + payload);
    }

    // 使用 Spring Integration 注解，注册消息监听器
    @ServiceActivator(inputChannel = Input2Receiver.INPUT)
    public void receive2(String payload){
        logger.info("Received2: " + payload);
    }

    // 对指定的消息通道进行转换
    @Transformer(inputChannel = Input2Receiver.INPUT, outputChannel = Input2Receiver.INPUT)
    public Object transform(Date message){
        String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(message);
        return str;
    }

    @StreamListener(Input3Receiver.INPUT)
    public void receive3(User payload){
        logger.info("Received3: user name is " + payload.getName() +" age is "+ payload.getAge());
    }
}
