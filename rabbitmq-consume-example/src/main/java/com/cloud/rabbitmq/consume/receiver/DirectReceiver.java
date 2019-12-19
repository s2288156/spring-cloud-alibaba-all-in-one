package com.cloud.rabbitmq.consume.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.cloud.rabbitmq.consume.config.RabbitConst.*;

/**
 * @author wcy
 */
@Slf4j
@Component
@RabbitListener(queues = QUEUE_DIRECT_A)
public class DirectReceiver {

    @RabbitHandler
    public void process(String msg) {
        log.info("DirectReceiver接收消息: {}", msg);
    }
}
