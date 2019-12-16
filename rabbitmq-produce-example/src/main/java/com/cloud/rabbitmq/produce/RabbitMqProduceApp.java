package com.cloud.rabbitmq.produce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wcy
 */
@SpringBootApplication
public class RabbitMqProduceApp {
    public static void main(String[] args) {
        SpringApplication.run(RabbitMqProduceApp.class, args);
    }
}
