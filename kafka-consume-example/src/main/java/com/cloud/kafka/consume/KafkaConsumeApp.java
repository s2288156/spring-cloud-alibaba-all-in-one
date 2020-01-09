package com.cloud.kafka.consume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wcy
 */
@SpringBootApplication
public class KafkaConsumeApp {
    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumeApp.class, args);
    }
}
