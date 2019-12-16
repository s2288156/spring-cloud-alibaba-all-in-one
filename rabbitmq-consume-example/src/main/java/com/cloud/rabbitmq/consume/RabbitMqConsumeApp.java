package com.cloud.rabbitmq.consume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wcy
 */
@SpringBootApplication
public class RabbitMqConsumeApp {
    public static void main(String[] args) {
        SpringApplication.run(RabbitMqConsumeApp.class, args);
    }
}
