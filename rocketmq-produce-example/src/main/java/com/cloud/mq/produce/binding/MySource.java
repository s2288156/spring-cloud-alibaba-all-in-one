package com.cloud.mq.produce.binding;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author wcy
 */
public interface MySource {

    @Output("output1")
    MessageChannel output1();
}
