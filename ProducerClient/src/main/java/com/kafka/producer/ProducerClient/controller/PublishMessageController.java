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

    @GetMapping("/publish/create-topic-and-publish/{message}")
    public ResponseEntity<?> createTopicAndPublish(@PathVariable String message){
        try {
            publisher.sendMessageToCreatedToptic(message);
            return ResponseEntity.ok("Message send Successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping("/publish/create-topic-by-config-and-publish/{message}")
    public ResponseEntity<?> createTopicByC0nfigAndPublish(@PathVariable String message){
        try {
            publisher.sendMessageToConfigBasedCreatedToptic(message);
            return ResponseEntity.ok("Message send Successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping("/publish/create-topic-by-config-3-partitions-and-publish/{message}")
    public ResponseEntity<?> createTopicByConfigWith3PartitionsAndPublish(@PathVariable String message){
        try {
            for(int i=0;i<1000000;i++) {
                publisher.sendMessageToConfigWith3PartitionsBasedCreatedToptic(message+i);
            }
            return ResponseEntity.ok("Message send Successfully");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
