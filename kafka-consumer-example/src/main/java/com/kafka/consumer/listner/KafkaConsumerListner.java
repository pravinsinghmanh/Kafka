package com.kafka.consumer.listner;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerListner {
/*
if you will not give consumer group id it wil give below error

No group.id found in consumer config, container properties, or @KafkaListener annotation;
a group.id is required when group management is used.

once you give group id then check log:
     : consumer-group: partitions assigned: [ProgramaticTopic-0]

*/
    @KafkaListener(topics = "ProgramaticTopic",groupId = "consumer-group")
    public void messageConsumer(String message){
        System.out.println("Consumer message : "+message);
    }
    @KafkaListener(topics = "3PartitionsTopic",groupId = "consumer-group-1")
    public void messageConsumerFrom3PartitionsTopic1(String message){
        System.out.println("Consumer message 1 : "+message);
    }

    @KafkaListener(topics = "3PartitionsTopic",groupId = "consumer-group-1")
    public void messageConsumerFrom3PartitionsTopic2(String message){
        System.out.println("Consumer message 2: "+message);
    }
    @KafkaListener(topics = "3PartitionsTopic",groupId = "consumer-group-1")
    public void messageConsumerFrom3PartitionsTopic3(String message){
        System.out.println("Consumer message 3: "+message);
    }
}
