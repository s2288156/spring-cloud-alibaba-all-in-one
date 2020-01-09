package com.cloud.kafka.produce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wcy
 */
@SpringBootApplication
public class KafkaProduceApp {
    public static void main(String[] args) {
        SpringApplication.run(KafkaProduceApp.class, args);
    }
}
