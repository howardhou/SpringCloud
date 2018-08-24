package com.rongzi.streamproductor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.SendTo;

@SpringBootApplication
public class StreamProductorApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamProductorApplication.class, args);
	}

}
