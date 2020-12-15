package com.wj.amqp.provider.topic;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wj
 * @version 1.0
 * @date 2020/12/8 0008
 * @description
 */
@Component
public class TopicMessageProvider {

    @Autowired
    private RabbitTemplate template;

    public void producesMessage(Object message){
        template.convertAndSend("develop.topic","develop.abc",message);

    }
}
