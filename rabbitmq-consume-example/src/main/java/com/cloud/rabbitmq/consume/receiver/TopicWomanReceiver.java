package com.cloud.rabbitmq.consume.receiver;

import com.cloud.rabbitmq.consume.config.TopicRabbitConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wcy
 */
@Slf4j
@Component
@RabbitListener(queues = TopicRabbitConfig.TOPIC_WOMAN)
public class TopicWomanReceiver {

    @RabbitHandler
    public void process(String msg) {
        log.info("topic woman接收消息：{}", msg);
    }
}
