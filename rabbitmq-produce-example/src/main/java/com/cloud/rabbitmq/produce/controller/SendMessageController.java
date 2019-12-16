package com.cloud.rabbitmq.produce.controller;

import com.cloud.rabbitmq.produce.config.DirectRabbitConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author wcy
 */
@Slf4j
@RestController
public class SendMessageController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/direct_msg")
    public String sendDirectMsg(String msg) {
        MyMessage message = new MyMessage();
        message.setMessageId(UUID.randomUUID().toString());
        message.setData(msg);
        message.setCreateTime(LocalDateTime.now().toString());

        rabbitTemplate.convertAndSend(DirectRabbitConfig.TEST_DIRECT_EXCHANGE, DirectRabbitConfig.TEST_DIRECT_ROUTING, message);
        return message.toString();
    }
}
