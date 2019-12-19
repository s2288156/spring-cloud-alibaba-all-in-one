package com.cloud.rabbitmq.consume.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.cloud.rabbitmq.consume.config.RabbitConst.QUEUE_FANOUT_B;
/**
 * @author wcy
 */
@Slf4j
@Component
@RabbitListener(queues = QUEUE_FANOUT_B)
public class FanoutReceiverB {

    @RabbitHandler
    public void process(String msg) {
        log.info("fanoutReceiverB ---> {}", msg);
    }
}
