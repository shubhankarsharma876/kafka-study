package com.consumer.Consumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {
    Logger logger = LoggerFactory.getLogger(KafkaMessageListener.class);

    @KafkaListener(topics = "Custom-Topic", groupId="id1")
    public void consumer1(String message){

        logger.info("consumed1 the message {}",message);
    }

    @KafkaListener(topics = "Custom-Topic", groupId="id1")
    public void consumer2(String message){

        logger.info("consumed2 the message {}",message);
    }

    @KafkaListener(topics = "Custom-Topic", groupId="id1")
    public void consumer3(String message){

        logger.info("consumed3 the message {}",message);
    }
}
