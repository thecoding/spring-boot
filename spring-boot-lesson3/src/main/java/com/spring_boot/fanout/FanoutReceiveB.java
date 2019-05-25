package com.spring_boot.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by zhouchao on 19/5/25.
 */
@Component
@RabbitListener(queues = "queueB")
public class FanoutReceiveB {

    @RabbitHandler
    public void receiveB(String info){
        System.out.println("queueB_receiver接收到消息是：" + info);
    }

}
