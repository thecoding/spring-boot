package com.spring_boot.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhouchao on 19/1/17.
 */
@Configuration
public class RabbitMqConfig {

    public static final String RABBIT_MQ_MESSAGE = "Message";
    public static final String RABBIT_MQ_OBJECT = "object";

    @Bean
    public Queue messageQueue(){
        return new Queue(RABBIT_MQ_MESSAGE);
    }


    @Bean
    public Queue objectQueue(){
        return new Queue(RABBIT_MQ_OBJECT);
    }
}
