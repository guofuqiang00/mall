package com.mall.config.rabbitmq;


import com.mall.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class Receiver {

    List<User> userList = new ArrayList<>();

    // queues是指要监听的队列的名字
    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void receiverDirectQueue(User user) {
        log.info("接收姓名为: "+user.getUsername()+"发过来的消息为: "+user.getMsg());
        if(user!=null){
            userList.add(user);
        }
    }

    public List<User> getMsg(){
        return userList;
    }


}
