package com.cloud.rabbitmq.consume.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.cloud.rabbitmq.consume.config.RabbitConst.*;

/**
 * @author wcy
 */
@Slf4j
@Component
@RabbitListener(queues = TEST_DIRECT_QUEUE)
public class DirectReceiver {

    @RabbitHandler
    public void process(String msg) {
        log.info("DirectReceiver接收消息: {}", msg);
    }
}
