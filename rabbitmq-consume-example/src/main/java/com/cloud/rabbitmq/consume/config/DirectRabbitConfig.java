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
    public Queue testDirectQueue() {
        return new Queue(TEST_DIRECT_QUEUE, true);
    }

    @Bean
    public DirectExchange testDirectExchange() {
        return new DirectExchange(TEST_DIRECT_EXCHANGE);
    }

    @Bean
    public Binding bindingDirect() {
        return BindingBuilder.bind(testDirectQueue())
                .to(testDirectExchange())
                .with(TEST_DIRECT_ROUTING);
    }
}
