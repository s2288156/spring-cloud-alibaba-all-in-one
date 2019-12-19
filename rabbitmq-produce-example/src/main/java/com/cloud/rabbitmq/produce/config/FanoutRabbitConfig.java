package com.cloud.rabbitmq.produce.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.cloud.rabbitmq.produce.config.RabbitConst.*;

/**
 * @author wcy
 */
@Configuration
public class FanoutRabbitConfig {


    @Bean
    public Queue queueA() {
        return new Queue(QUEUE_FANOUT_A);
    }

    @Bean
    public Queue queueB() {
        return new Queue(QUEUE_FANOUT_B);
    }

    @Bean
    public Queue queueC() {
        return new Queue(QUEUE_FANOUT_C);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(EXCHANGE_FANOUT);
    }

    @Bean
    public Binding bindingExchangeA() {
        return BindingBuilder.bind(queueA()).to(fanoutExchange());
    }

    @Bean
    public Binding bindingExchangeB() {
        return BindingBuilder.bind(queueB()).to(fanoutExchange());
    }

    @Bean
    public Binding bindingExchangeC() {
        return BindingBuilder.bind(queueC()).to(fanoutExchange());
    }

}
