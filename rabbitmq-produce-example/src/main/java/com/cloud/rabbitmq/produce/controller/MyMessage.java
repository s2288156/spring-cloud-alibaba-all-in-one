package com.cloud.rabbitmq.produce.controller;

import lombok.Data;

import java.io.Serializable;

@Data
public class MyMessage implements Serializable {
    private static final long serialVersionUID = -3874422846022696259L;
    private String messageId;

    private String data;

    private String createTime;

    private String topic;
}