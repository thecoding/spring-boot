package com.spring_boot.topic;

import com.spring_boot.config.TopicRabbitMqConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhouchao on 19/5/25.
 */


@Component
public class TopicSender {


    @Autowired
    private AmqpTemplate amqpTemplate;


    public void send1(){
        System.out.println(" send1 发送消息.... ");

        String content = "send1的消息";
//        String exchange, String routingKey, Object object
        this.amqpTemplate.convertAndSend(TopicRabbitMqConfig.TOPIC_EXCHANGE, TopicRabbitMqConfig.message, content);
    }



    public void send2(){
        System.out.println(" send2 发送消息.... ");

        String content = "send2的消息";
        this.amqpTemplate.convertAndSend(TopicRabbitMqConfig.TOPIC_EXCHANGE, TopicRabbitMqConfig.messages, content);
    }

}
