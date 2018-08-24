package com.rongzi.streamproductor;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Input3Sender {
    String INPUT = "input3";

    @Output(Input3Sender.INPUT)
    MessageChannel output();
}
