package com.cloud.rabbitmq.consume.receiver;

import com.cloud.rabbitmq.consume.config.FanoutRabbitConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wcy
 */
@Slf4j
@Component
@RabbitListener(queues = FanoutRabbitConfig.QUEUE_C)
public class FanoutReceiverC {

    @RabbitHandler
    public void process(String msg) {
        log.info("fanoutReceiverC ---> {}", msg);
    }
}
