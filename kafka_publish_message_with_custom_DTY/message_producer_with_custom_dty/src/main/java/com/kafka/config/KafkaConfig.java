package com.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class KafkaConfig {

    @Bean
    public NewTopic createTopic(){
        return new NewTopic("TOPIC",1,(short)1);
    }
}
