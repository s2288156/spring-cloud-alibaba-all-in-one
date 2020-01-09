package com.cloud.kafka.produce;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author wcy
 */
@EnableKafka
@Slf4j
@SpringBootApplication
public class KafkaProduceApp implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(KafkaProduceApp.class, args).close();
    }

    @Autowired
    private KafkaTemplate<String, String> template;

    private final CountDownLatch latch = new CountDownLatch(3);

    @Override
    public void run(String... args) throws Exception {
        this.template.send("test-topic", "foo1");
        this.template.send("test-topic", "foo2");
        this.template.send("test-topic", "foo3");
        latch.await(60, TimeUnit.SECONDS);
        log.info("all received");
    }
}
