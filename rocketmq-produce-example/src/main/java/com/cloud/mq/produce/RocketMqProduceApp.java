package com.cloud.mq.produce;

import com.cloud.mq.produce.binding.MySource;
import org.apache.rocketmq.common.message.MessageConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wcy
 */
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
    public Message<String> send1(String msg, String tag) {
        Message<String> message = MessageBuilder.withPayload(msg).
                setHeader(MessageConst.PROPERTY_TAGS, tag).
                build();
        source.output1().send(message);
        return message;
    }

    @GetMapping("/send2")
    public Message<String> send2(String msg, String tag) {
        Message<String> message = MessageBuilder.withPayload(msg).
                setHeader(MessageConst.PROPERTY_TAGS, tag).
                build();
        source.output2().send(message);
        return message;
    }

}
