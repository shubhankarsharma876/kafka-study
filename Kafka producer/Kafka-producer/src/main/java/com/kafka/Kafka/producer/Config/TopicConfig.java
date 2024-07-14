package com.kafka.Kafka.producer.Config;

import org.apache.kafka.clients.admin.NewTopic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfig {

//This is to create the custom topic else the spring will make a default topic according to itself...

    @Bean
    public NewTopic createTopic(){
        return new NewTopic("Custom-Topic",2,(short)5);
    }


}
