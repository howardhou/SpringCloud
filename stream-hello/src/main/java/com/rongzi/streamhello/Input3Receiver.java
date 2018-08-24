package com.rongzi.streamhello;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Input3Receiver {
    String INPUT = "input3";

    @Input(Input3Receiver.INPUT)
    SubscribableChannel receive();
}
