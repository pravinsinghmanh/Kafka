package com.kafka.publisher;

import com.kafka.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import java.util.concurrent.CompletableFuture;

@Configuration
public class KafkaProducerWithCustomDataType {
    @Autowired
    public KafkaTemplate<String, Customer> kafkaTempelte;

    public void sendMessageToConfigBasedCreatedToptic(Customer customer) {
        CompletableFuture<SendResult<String, Customer>> future = kafkaTempelte.send("TOPIC", customer);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Send MSG : ["+customer.toString()+ " ] Offset value : "+result.getRecordMetadata().offset());
            } else {
                System.out.println("Unable to MSG : [ "+customer.toString()+ " ] reason : "+ex.getMessage());
            }
        });
    }
}
