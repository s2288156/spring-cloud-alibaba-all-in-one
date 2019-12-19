package com.cloud.rabbitmq.consume.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.cloud.rabbitmq.consume.config.RabbitConst.*;

/**
 * @author wcy
 */
@Configuration
public class TopicRabbitConfig {

    @Bean
    public Queue topicQueueA() {
        return new Queue(QUEUE_TOPIC_A);
    }

    @Bean
    public Queue topicQueueB() {
        return new Queue(QUEUE_TOPIC_B);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_TOPIC);
    }

    @Bean
    public Binding bindingManExchangeMessage() {
        return BindingBuilder.bind(topicQueueA()).to(exchange()).with(ROUTING_KEY_MAN);
    }

    @Bean
    public Binding bindingWomanExchangeMessage() {
        return BindingBuilder.bind(topicQueueA()).to(exchange()).with(ROUTING_KEY_WOMAN);
    }

    @Bean
    public Binding bindingAllExchangeMessage() {
        return BindingBuilder.bind(topicQueueB()).to(exchange()).with("topic.#");
    }

}
