package com.example.kafka;

import com.example.modle.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class JsonProducer {

     private static final Logger LOGGER = LoggerFactory.getLogger(JsonProducer.class);

     @Autowired
     private KafkaTemplate<String , String> kafkaTemplate;
     private final ObjectMapper objectMapper=new ObjectMapper();


     public User sendUserDetails(User user) throws JsonProcessingException {
          LOGGER.info("user generated with name "+user.getUserName());
          if (user.getUserGender()=="male") {
               kafkaTemplate.send("user", objectMapper.writeValueAsString(user));
               return user;
          }else {
               return null;
          }
     }
}
