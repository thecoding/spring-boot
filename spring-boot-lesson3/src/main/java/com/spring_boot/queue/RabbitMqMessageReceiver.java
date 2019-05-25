package com.spring_boot.queue;

import com.spring_boot.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by zhouchao on 19/1/17.
 */
@Component
@RabbitListener(queues = RabbitMqConfig.RABBIT_MQ_MESSAGE)
public class RabbitMqMessageReceiver {

    @RabbitHandler
    public void process(String str) {
        System.out.println("receive 1 :  " + str);
    }

}
