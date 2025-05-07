package com.kafka.producer.ProducerClient.controller;


import com.kafka.producer.ProducerClient.publisher.KafkaServerPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer-app")
public class PublishMessageController {
    @Autowired
    private KafkaServerPublisher publisher;
    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable String message){
        try {
            publisher.sendMessageDirectlyWithOutCreatingToptic(message);
            return ResponseEntity.ok("Message send Successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
