package com.spring_boot.queue;

import com.spring_boot.config.RabbitMqConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhouchao on 19/1/17.
 */
@Component
public class RabbitMqMessageSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String str){
        this.amqpTemplate.convertAndSend(RabbitMqConfig.RABBIT_MQ_MESSAGE,str);
    }
}
