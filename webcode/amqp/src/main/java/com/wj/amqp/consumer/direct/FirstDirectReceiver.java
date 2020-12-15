package com.wj.amqp.consumer.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author wj
 * @version 1.0
 * @date 2020/12/7 0007
 * @description @RabbitListener配合 @RabbitHandler实现消息接收（@RabbitListener放置在类上）
 */
@Component
@RabbitListener(queues = "direct")
public class FirstDirectReceiver {

  @RabbitHandler
  public void messageReceiver(Map message) {
    System.out.println("DirectReceiver1收到消息：" + message.toString());
  }
}
