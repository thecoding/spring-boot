package com.spring_boot.topic;

import com.spring_boot.config.TopicRabbitMqConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by zhouchao on 19/5/25.
 */

@Component
@RabbitListener(queues = TopicRabbitMqConfig.message)
public class TopicReceiver {


    @RabbitHandler
    public void receive(String receiveInfo){
        System.out.println("receive1 收到的消息是："+ receiveInfo);
    }
}
