package com.cloud.mq.produce;

import com.cloud.mq.produce.binding.MySource;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author wcy
 */
@Slf4j
@RestController
@SpringBootApplication
@EnableBinding({MySource.class})
public class RocketMqProduceApp {
    public static void main(String[] args) {
        SpringApplication.run(RocketMqProduceApp.class, args);
    }

    @Autowired
    private MySource source;

    @GetMapping("/send1")
    public Object send1(String msg, String tag) {
        Message<String> message = MessageBuilder.withPayload(msg).
                setHeader(MessageConst.PROPERTY_TAGS, tag).
                build();
        boolean send = source.output1().send(message);
        log.info("{}", send);
        if (send) {
            return message;
        }
        return "send fail";
    }

    @GetMapping("/send2")
    public Object send2(String msg, String tag, Integer delay) {
        log.info("{}", System.currentTimeMillis());
        Message<String> message = MessageBuilder.withPayload(msg).
                setHeader(MessageConst.PROPERTY_TAGS, tag).
                setHeader(MessageConst.PROPERTY_DELAY_TIME_LEVEL, delay).
                build();
        boolean send = source.output2().send(message);
        log.info("{}", send);
        if (send) {
            return message;
        }
        return "send fail";
    }

}
