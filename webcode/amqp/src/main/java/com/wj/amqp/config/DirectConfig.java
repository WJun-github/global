package com.wj.amqp.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wj
 * @version 1.0
 * @date 2020/12/7 0007
 * @description
 */
@Configuration
public class DirectConfig {

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("develop.direct");
    }

    @Bean
    public Queue directQueue(){
        return new Queue("direct",true);
    }

    @Bean
    public Binding directBinding(){
        return BindingBuilder.bind(directQueue()).to(directExchange()).with("checkDate");
    }
}
