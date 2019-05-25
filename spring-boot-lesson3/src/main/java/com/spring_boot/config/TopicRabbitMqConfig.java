package com.spring_boot.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhouchao on 19/5/25.
 *
 *
 * topic
 */
@Configuration
public class TopicRabbitMqConfig {

    public final static String message = "topic.message";
    public final static String messages = "topic.messages";


    public final static String TOPIC_EXCHANGE = "TOPIC_EXCHANGE";


    @Bean
    public Queue topicMessageQueue(){
        return new Queue(TopicRabbitMqConfig.message);
    }


    @Bean
    public Queue topicMessagesQueue(){
        return new Queue(TopicRabbitMqConfig.messages);
    }


    @Bean
    TopicExchange exchange(){
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    @Bean
    Binding bindingTopicExchange(Queue topicMessageQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicMessageQueue).to(topicExchange).with(TopicRabbitMqConfig.message);
    }



    //    Topic Exchange主要有两种通配符：# 和 *
    //      *（星号）：可以（只能）匹配一个单词
    //      #（井号）：可以匹配多个单词（或者零个）


    //    当一个队列被绑定为binding key为”#”时，它将会接收所有的消息，这类似于广播形式的交换机模式。
    //    当binding key不包含”*”和”#”时，这类似于Direct Exchange直连交换机模式。
    @Bean
    Binding bindingTopicExchangeMessages(Queue topicMessagesQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicMessagesQueue).to(topicExchange).with("topic.#");
    }



}
