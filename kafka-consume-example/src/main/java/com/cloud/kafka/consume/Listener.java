package com.cloud.kafka.consume;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author wcy
 */
@Component
@Slf4j
public class Listener {

    @KafkaListener(topics = "test-topic")
    public void listen(String data) {
        log.info("listen - {}", data);
    }
}
