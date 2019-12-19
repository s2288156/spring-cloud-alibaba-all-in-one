package com.cloud.rabbitmq.produce.config;

/**
 * @author wcy
 */
public class RabbitConst {

    public static final String QUEUE_DIRECT_A = "queue-direct-a";
    public static final String QUEUE_DIRECT_B = "queue-direct-b";
    public static final String QUEUE_FANOUT_A = "queue-fanout-a";
    public static final String QUEUE_FANOUT_B = "queue-fanout-b";
    public static final String QUEUE_FANOUT_C = "queue-fanout-c";
    public static final String QUEUE_TOPIC_A = "queue-topic-a";
    public static final String QUEUE_TOPIC_B = "queue-topic-b";

    public static final String EXCHANGE_DIRECT = "exchange-direct";
    public static final String EXCHANGE_TOPIC = "exchange-topic";
    public static final String EXCHANGE_FANOUT = "exchange-fanout";


    public static final String ROUTING_KEY_MAN= "topic.man";
    public static final String ROUTING_KEY_WOMAN= "topic.woman";
    public static final String ROUTING_KEY_DIRECT= "topic.direct";
}
