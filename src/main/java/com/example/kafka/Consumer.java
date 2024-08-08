package com.example.kafka;

import org.apache.kafka.common.protocol.types.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "user", groupId = "myGroup-1")
    public void consume(String message){
        LOGGER.info("message recived by produces ->>>>"+message);
    }
}
