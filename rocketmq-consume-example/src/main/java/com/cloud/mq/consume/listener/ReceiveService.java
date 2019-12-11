package com.cloud.mq.consume.listener;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

/**
 * @author wcy
 */
@Service
public class ReceiveService {

    @StreamListener("input1")
    public void receiveInput1(String receiveMsg) {
        System.out.println("input1 receive: " + receiveMsg);
    }
}
