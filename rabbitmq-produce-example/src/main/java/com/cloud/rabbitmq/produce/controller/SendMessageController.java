package com.cloud.rabbitmq.produce.controller;

import com.alibaba.fastjson.JSON;
import com.cloud.rabbitmq.produce.config.DirectRabbitConfig;
import com.cloud.rabbitmq.produce.config.FanoutRabbitConfig;
import com.cloud.rabbitmq.produce.config.TopicRabbitConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.cloud.rabbitmq.produce.config.TopicRabbitConfig.*;

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

        rabbitTemplate.convertAndSend(DirectRabbitConfig.TEST_DIRECT_EXCHANGE, DirectRabbitConfig.TEST_DIRECT_ROUTING, JSON.toJSONString(message));
        return message.toString();
    }

    @GetMapping("/topic/man")
    public String sendTopicMan(String msg) {
        MyMessage myMessage = new MyMessage();
        myMessage.setData(msg);
        myMessage.setTopic(TOPIC_MAN);

        rabbitTemplate.convertAndSend(TOPIC_EXCHANGE, TOPIC_MAN, JSON.toJSONString(myMessage));
        return myMessage.toString();
    }

    @GetMapping("/topic/woman")
    public MyMessage sendTopicWoman(String msg) {
        MyMessage myMessage = new MyMessage();
        myMessage.setData(msg);
        myMessage.setTopic(TOPIC_WOMAN);

        rabbitTemplate.convertAndSend(TOPIC_EXCHANGE, TOPIC_WOMAN, JSON.toJSONString(myMessage));
        return myMessage;
    }

    @GetMapping("/fanout_msg")
    public MyMessage sendFanoutMsg(String msg) {
        MyMessage myMessage = new MyMessage();
        myMessage.setData(msg);

        rabbitTemplate.convertAndSend(FanoutRabbitConfig.FANOUT_EXCHANGE, null, JSON.toJSONString(myMessage));
        return myMessage;
    }

}
