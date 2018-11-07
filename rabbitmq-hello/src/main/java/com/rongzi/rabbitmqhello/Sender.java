package com.rongzi.rabbitmqhello;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        Date date = new Date();
        String context = "hello " + date.toString();
        System.out.println("\n");
        System.out.println("Sender : " + context);

        // 发送到 Hello 队列中
        this.rabbitTemplate.convertAndSend("hello", context);
    }


}
