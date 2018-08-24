package com.rongzi.streamproductor;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Input2Sender {
    String INPUT = "input2";

    @Output(Input2Sender.INPUT)
    MessageChannel output();
}
