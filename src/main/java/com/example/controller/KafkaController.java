package com.example.controller;

import com.example.kafka.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api-kafka")
public class KafkaController {

    @Autowired
    private Producer producer;

    @GetMapping("/fetch")
    public String sendMessage(@RequestParam("message") String message){
        producer.sendMessage(message);
        return "success";
    }

}
