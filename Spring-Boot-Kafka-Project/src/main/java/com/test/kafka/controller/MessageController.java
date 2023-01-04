package com.test.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.kafka.producer.consumer.KafkaProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

	@Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/publish")
    public ResponseEntity<String> produceMessage(@RequestParam("message") String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the topic");
    }
    
    
}