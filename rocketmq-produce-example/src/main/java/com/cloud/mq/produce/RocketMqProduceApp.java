package com.cloud.mq.produce;

import com.cloud.mq.produce.binding.MySource;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.MessageConst;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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

    @GetMapping("/send")
    public Message send(String msg) {
        Map<String, Object> headers = new HashMap<>();
        headers.put(MessageConst.PROPERTY_TAGS, "tagStr");
        Message message = MessageBuilder.withPayload(msg).setHeader(MessageConst.PROPERTY_TAGS, "tagStr").build();
        source.output1().send(message);
        return message;
    }

    @GetMapping("/send1")
    public void send1(String msg) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("producer_group11");
        producer.setNamesrvAddr("192.168.30.204:9876");
        producer.start();
        org.apache.rocketmq.common.message.Message message = new org.apache.rocketmq.common.message.Message("test-topic", "tagStr", "message from rocketmq producer".getBytes());
        producer.send(message);
        System.out.println(message);
        producer.shutdown();
    }

}
