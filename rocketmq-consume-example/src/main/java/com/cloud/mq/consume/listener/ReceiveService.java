package com.cloud.mq.consume.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

/**
 * @author wcy
 */
@Slf4j
@Service
public class ReceiveService {

    @StreamListener("input1")
    public void receiveInput1(Message<String> receiveMsg) {
        log.info("input1 receive: {}", receiveMsg.getPayload());
    }

    @StreamListener("input2")
    public void receiveInput2(Message<String> receiveMsg) {
        log.info("input2 receive: {} : {}", System.currentTimeMillis(), receiveMsg.getPayload());
    }
}
