package com.cloud.rabbitmq.produce.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wcy
 */
@Configuration
public class TopicRabbitConfig {
    public static final String TOPIC_MAN = "topic.man";
    public static final String TOPIC_WOMAN = "topic.woman";
    public static final String TOPIC_EXCHANGE = "topicExchange";

    @Bean
    public Queue manQueue() {
        return new Queue(TOPIC_MAN);
    }

    @Bean
    public Queue womanQueue() {
        return new Queue(TOPIC_WOMAN);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    @Bean
    public Binding bindingManExchangeMessage() {
        return BindingBuilder.bind(manQueue()).to(exchange()).with(TOPIC_MAN);
    }

    @Bean
    public Binding bindingAllExchangeMessage() {
        return BindingBuilder.bind(womanQueue()).to(exchange()).with("topic.#");
    }

}
