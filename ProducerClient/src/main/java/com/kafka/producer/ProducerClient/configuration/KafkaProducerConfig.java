package com.kafka.producer.ProducerClient.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerConfig {
    @Bean
    public NewTopic createTopic(){
        return new NewTopic("ProgramaticTopic",1,(short)1);
    }
    @Bean
    public NewTopic createTopicWithTwoPartitions(){
        return new NewTopic("3PartitionsTopic",3,(short)1);
    }
}
