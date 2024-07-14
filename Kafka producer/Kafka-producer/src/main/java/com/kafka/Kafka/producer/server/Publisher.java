package com.kafka.Kafka.producer.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class Publisher {
    @Autowired
    private KafkaTemplate<String, Object> template;

    public void sendMessageToTopic(String message){
//        template.send("name",message); it can be writen as below
        CompletableFuture<SendResult<String, Object>> future = template.send("Custom-Topic", message);
        future.whenComplete((result,ex)->{
            if(ex==null){
                System.out.println("send message=["+message+"] with the offset=["+ result.getRecordMetadata().offset()+"]");
            }else{
                System.out.println("Unable to send message=["+message+"] due to:" + ex.getMessage());
            }
        });
    }
}
