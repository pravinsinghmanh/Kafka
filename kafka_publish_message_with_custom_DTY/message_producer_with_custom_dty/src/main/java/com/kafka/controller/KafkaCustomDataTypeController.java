package com.kafka.controller;

import com.kafka.pojo.Customer;

import com.kafka.publisher.KafkaProducerWithCustomDataType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer-app")
public class KafkaCustomDataTypeController {

    @Autowired
    private KafkaProducerWithCustomDataType publish;

    @PostMapping("/publish")
    public ResponseEntity<?> publishMessage(@RequestBody Customer customer){
        try{
            publish.sendMessageToConfigBasedCreatedToptic(customer);
            return ResponseEntity.ok("Message published successfully ");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
