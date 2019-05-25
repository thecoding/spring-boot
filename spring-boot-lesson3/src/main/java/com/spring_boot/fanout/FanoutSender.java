package com.spring_boot.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhouchao on 19/5/25.
 */
@Component
public class FanoutSender {

    @Autowired
    AmqpTemplate amqpTemplate;


    public void send(){
        String message = " fanout 发送的消息";
        this.amqpTemplate.convertAndSend("fanoutExchange","",message);
    }
}
