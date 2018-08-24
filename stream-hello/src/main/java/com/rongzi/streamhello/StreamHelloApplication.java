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

//	@StreamListener(Processor.INPUT)
//	@SendTo(Processor.OUTPUT)
//	public String handle(String value) {
//		System.out.println("Received: " + value);
//		return value.toUpperCase();
//	}
}
