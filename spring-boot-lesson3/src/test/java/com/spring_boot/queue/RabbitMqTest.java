package com.spring_boot.queue;

import com.spring_boot.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by zhouchao on 19/1/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqTest {

    @Autowired
    private RabbitMqMessageSender rabbitMqMessageSender;

    @Autowired
    private RabbitMqObjectSender rabbitMqObjectSender;


    /**
     *  一对一和一对多取决于是否有多少个接收者
     */
    @Test
    public void send(){
        for (int i = 0; i < 100; i++) {
            rabbitMqMessageSender.send("hello_Mq  " + i + "   " + new Date());
        }
    }


    /**
     *  多对多取决于是否有多少个发送者
     *  如下，RabbitMqObjectReceiver  RabbitMqMessageReceiver2 都可以接收到信息
     */
    @Test
    public void manyToManySend(){
        User u = new User();
        u.setUserName("person");
        u.setPassWord("password");
        for (int i = 0; i < 100; i++) {
            rabbitMqMessageSender.send(" string send " + i + "  " + new Date());
            u.setUserName("person"+i);
            u.setNickName(new Date() +"");
            rabbitMqObjectSender.send(u);
        }
    }
}
