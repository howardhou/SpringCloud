package com.rongzi.streamhello;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface Input2Receiver {
    String INPUT = "input2";

    @Input(Input2Receiver.INPUT)
    SubscribableChannel receive();
}
