package com.rongzi.streamhello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.SendTo;

//@EnableBinding(Processor.class)
@SpringBootApplication
public class StreamHelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamHelloApplication.class, args);
	}

	//消息反馈, 处理完消息之后，将结果反馈给对方
//	@StreamListener(Processor.INPUT)
//	@SendTo(Processor.OUTPUT)
//	public String handle(String value) {
//		System.out.println("Received: " + value);
//		return value.toUpperCase();
//	}
}
