package com.cloud.rabbitmq.consume.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.cloud.rabbitmq.consume.config.RabbitConst.QUEUE_TOPIC_A;
/**
 * @author wcy
 */
@Slf4j
@Component
@RabbitListener(queues = QUEUE_TOPIC_A)
public class TopicReceiver {

    @RabbitHandler
    public void process(String msg) {
        log.info("queue-topic-a接收消息：{}", msg);
    }
}
