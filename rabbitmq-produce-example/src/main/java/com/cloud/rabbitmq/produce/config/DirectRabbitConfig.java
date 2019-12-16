package com.cloud.rabbitmq.produce.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wcy
 */
@Configuration
public class DirectRabbitConfig {

    public static final String TEST_DIRECT_QUEUE = "test-direct-queue";
    public static final String TEST_DIRECT_EXCHANGE = "test-direct-exchange";
    public static final String TEST_DIRECT_ROUTING = "test-direct-routing";

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
