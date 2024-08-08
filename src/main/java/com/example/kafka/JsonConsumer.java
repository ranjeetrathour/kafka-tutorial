package com.example.kafka;

import com.example.modle.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonConsumer.class);
    private final ObjectMapper objectMapper=new ObjectMapper();

    @KafkaListener(topics = "user", groupId = "myGroup-1")
    public User getUserByProducer(String user) throws JsonProcessingException {
     return objectMapper.readValue(user, User.class);
    }
}
