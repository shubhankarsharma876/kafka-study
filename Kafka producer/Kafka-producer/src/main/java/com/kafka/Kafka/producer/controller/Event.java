package com.kafka.Kafka.producer.controller;

import com.kafka.Kafka.producer.server.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer-app")
public class Event {

    @Autowired
    private Publisher publisher;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?>publishMessage(@PathVariable String message){
        try {

            for (int i = 0; i <100000 ; i++) {
                publisher.sendMessageToTopic(message);
            }

            return ResponseEntity.ok("message published");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

}
