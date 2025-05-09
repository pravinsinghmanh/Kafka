package com.kafka.producer.ProducerClient.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class KafkaServerPublisher {
    @Autowired
    KafkaTemplate<String, Object> kafkaTempelte;

    public void sendMessageDirectlyWithOutCreatingToptic(String message) {
        CompletableFuture<SendResult<String, Object>> future = kafkaTempelte.send("publishMessageWithoutCreateringTopic", message);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Send MSG : ["+message+ " ] Offset value : "+result.getRecordMetadata().offset());
            } else {
                System.out.println("Unable to MSG : [ "+message+ " ] reason : "+ex.getMessage());
            }

        });
    }

    public void sendMessageToCreatedToptic(String message) {
        CompletableFuture<SendResult<String, Object>> future = kafkaTempelte.send("publishMessageToCreatedToptic", message);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Send MSG : ["+message+ " ] Offset value : "+result.getRecordMetadata().offset());
            } else {
                System.out.println("Unable to MSG : [ "+message+ " ] reason : "+ex.getMessage());
            }

        });
    }

    public void sendMessageToConfigBasedCreatedToptic(String message) {
        CompletableFuture<SendResult<String, Object>> future = kafkaTempelte.send("ProgramaticTopic", message);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Send MSG : ["+message+ " ] Offset value : "+result.getRecordMetadata().offset());
            } else {
                System.out.println("Unable to MSG : [ "+message+ " ] reason : "+ex.getMessage());
            }

        });
    }

    public void sendMessageToConfigWith3PartitionsBasedCreatedToptic(String message) {
        CompletableFuture<SendResult<String, Object>> future = kafkaTempelte.send("3PartitionsTopic", message);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Send MSG : ["+message+ " ] Offset value : "+result.getRecordMetadata().offset());
            } else {
                System.out.println("Unable to MSG : [ "+message+ " ] reason : "+ex.getMessage());
            }

        });
    }
}
