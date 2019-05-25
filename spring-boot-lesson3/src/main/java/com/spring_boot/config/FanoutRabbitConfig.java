package com.spring_boot.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhouchao on 19/5/25.
 */
@Configuration
public class FanoutRabbitConfig {


    @Bean
    public Queue queueA(){
        return new Queue("queueA");
    }

    @Bean
    public Queue queueB(){
        return new Queue("queueB");
    }

    @Bean
    public Queue queueC(){
        return new Queue("queueC");
    }

    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    Binding bindingFanoutExchangeA(Queue queueA,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queueA).to(fanoutExchange);
    }

    @Bean
    Binding bindingFanoutExchangeB(Queue queueB,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queueB).to(fanoutExchange);
    }


    @Bean
    Binding bindingFanoutExchangeC(Queue queueC,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queueC).to(fanoutExchange);
    }

}
