package com.cloud.mq.consume.listener;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

/**
 * @author wcy
 */
@Service
public class ReceiveService {

    @StreamListener("input1")
    public void receiveInput1(Message<byte[]> receiveMsg) {
        System.out.println("input1 receive: " + new String(receiveMsg.getPayload()));
    }
}
