package com.rongzi.streamproductor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

import java.util.Date;


@EnableBinding(Input2Sender.class)
public class Input2SenderImp {
    private static Logger logger = LoggerFactory.getLogger(Input2SenderImp.class);

    @Bean
    //定义了输出绑定
    // poller 参数将方法设置为轮询执行
    @InboundChannelAdapter(value = Input2Sender.INPUT, poller = @Poller(fixedDelay = "2000"))
    public MessageSource<Date> timerMessageSource(){
        return () -> new GenericMessage<>(new Date());
    }
}
