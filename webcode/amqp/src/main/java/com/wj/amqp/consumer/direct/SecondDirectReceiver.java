package com.wj.amqp.consumer.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author wj
 * @version 1.0
 * @date 2020/12/8 0008
 * @description
 */
@Component
public class SecondDirectReceiver {

  @RabbitListener(queues = "direct")
  @RabbitHandler
  public void processMessage(Map message) {
    System.out.println("DirectReceiver2收到消息：" + message.toString());
  }
}
