package com.wj.amqp.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wj
 * @version 1.0
 * @date 2020/12/8 0008
 * @description
 */
@Configuration
public class TopicConfig {

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange("develop.topic");
    }

    @Bean
    public Queue topicQueue(){
        return new Queue("topic",true);
    }

    @Bean
    public Binding topicBinding(){
        return BindingBuilder.bind(topicQueue()).to(exchange()).with("develop.*");
    }
}
