package com.kafka.listner;

import com.kafka.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaListnerForCustomDataType {

    @KafkaListener(topics = "TOPIC" , groupId = "topic-consumer")
    public void onMessageReceived(Customer customer){
        System.out.println("Received message : "+customer.toString());
    }
}
