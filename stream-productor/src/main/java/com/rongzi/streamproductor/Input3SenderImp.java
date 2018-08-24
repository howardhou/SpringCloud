package com.rongzi.streamproductor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;


@EnableBinding(Input3Sender.class)
public class Input3SenderImp {
    private static Logger logger = LoggerFactory.getLogger(Input3SenderImp.class);

    @Bean
    //定义了输出绑定
    // poller 参数将方法设置为轮询执行
    @InboundChannelAdapter(value = Input3Sender.INPUT, poller = @Poller(fixedDelay = "3000"))
    public MessageSource<String> userMessageSource(){
        return () -> new GenericMessage<>("{\"name\":\"dongdong\", \"age\":36}");
    }
}
