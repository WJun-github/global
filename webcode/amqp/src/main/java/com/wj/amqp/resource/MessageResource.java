package com.wj.amqp.resource;

import com.wj.amqp.provider.direct.DirectMessageProvider;
import com.wj.amqp.provider.topic.TopicMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author wj
 * @version 1.0
 * @date 2020/12/7 0007
 * @description
 */
@Slf4j
@RestController
@RequestMapping("/message")
public class MessageResource {

    @Autowired
    private DirectMessageProvider directMessageProvider;

    @Autowired
    private TopicMessageProvider topicMessageProvider;

    @GetMapping("/send/{messageBody}")
    public String sendMessage(@PathVariable("messageBody") String messageBody){
        Map<String,Object> message=new HashMap<>(16);
        message.put("messageId", UUID.randomUUID().toString().replaceAll("-","").toLowerCase());
        message.put("messageBody",messageBody);
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        message.put("publishTime",currentTime);
        //direct模式
        directMessageProvider.producesMessage(message);
        //topic模式
        topicMessageProvider.producesMessage(message);
        return "ok";
    }

}
