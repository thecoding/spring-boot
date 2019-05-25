package com.spring_boot.queue;

import com.spring_boot.fanout.FanoutSender;
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
public class FanoutTest {


    @Autowired
    FanoutSender sender;


    @Test
    public void test(){
        sender.send();
    }
}
