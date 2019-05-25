package com.spring_boot.queue;

import com.spring_boot.topic.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by zhouchao on 19/5/25.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicTest {


    @Autowired
    TopicSender topicSender;


    @Test
    public void test1(){
        topicSender.send1();
    }

//    send1 发送消息....
//    receive1 收到的消息是：send1的消息
//    receive2 接收到消息为：send1的消息



//    发送send1会匹配到topic.#和topic.message 两个Receiver都可以收到消息，
//    发送send2只有topic.#可以匹配所有只有Receiver2监听到消息

    @Test
    public void test2(){
        topicSender.send2();
//        send2 发送消息....
//        receive2 接收到消息为：send2的消息
    }

}
