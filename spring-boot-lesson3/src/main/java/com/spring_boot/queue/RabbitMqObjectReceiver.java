package com.spring_boot.queue;

import com.spring_boot.bean.User;
import com.spring_boot.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by zhouchao on 19/1/17.
 */
@Component
public class RabbitMqObjectReceiver {

    @RabbitListener(queues = RabbitMqConfig.RABBIT_MQ_OBJECT)
    @RabbitHandler
    public void process(User user) {
        System.out.println("Object 1 :  " + user.toString());
    }

}
