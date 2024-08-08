package com.example.controller;

import com.example.kafka.JsonProducer;
import com.example.kafka.Producer;
import com.example.modle.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-kafka")
public class KafkaController {

    @Autowired
    private Producer producer;
    @Autowired
    private JsonProducer jsonProducer;

    @GetMapping("/fetch")
    public String sendMessage(@RequestParam("message") String message){
        producer.sendMessage(message);
        return "success";
    }

    @PostMapping("/sendUser")
    public User sendUser(@RequestBody User user) throws JsonProcessingException {
        jsonProducer.sendUserDetails(user);
        return user;
    }

}
