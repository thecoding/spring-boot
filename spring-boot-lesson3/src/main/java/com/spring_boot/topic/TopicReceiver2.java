package com.spring_boot.topic;

import com.spring_boot.config.TopicRabbitMqConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by zhouchao on 19/5/25.
 */
@Component
@RabbitListener(queues = TopicRabbitMqConfig.messages)
public class TopicReceiver2 {


    @RabbitHandler
    public void receive(String receiveInfo){
        System.out.println("receive2 接收到消息为：" + receiveInfo);
    }
}
