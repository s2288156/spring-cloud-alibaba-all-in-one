package com.cloud.rabbitmq.consume.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.cloud.rabbitmq.consume.config.RabbitConst.*;
/**
 * @author wcy
 */
@Configuration
public class DirectRabbitConfig {

    @Bean
    public Queue directQueueA() {
        return new Queue(QUEUE_DIRECT_A, true);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(EXCHANGE_DIRECT);
    }

    @Bean
    public Binding bindingDirect() {
        return BindingBuilder.bind(directQueueA())
                .to(directExchange())
                .with(ROUTING_KEY_DIRECT);
    }
}
