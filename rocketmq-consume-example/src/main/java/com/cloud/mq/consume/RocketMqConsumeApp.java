package com.cloud.mq.consume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author wcy
 */
@EnableBinding({RocketMqConsumeApp.MySink.class})
@SpringBootApplication
public class RocketMqConsumeApp {
    public static void main(String[] args) {
        SpringApplication.run(RocketMqConsumeApp.class, args);
    }

    public interface MySink {
        @Input("input1")
        SubscribableChannel input1();
    }
}
