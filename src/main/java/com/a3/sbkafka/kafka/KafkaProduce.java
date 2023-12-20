package com.a3.sbkafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProduce {
    public static final Logger logger = LoggerFactory.getLogger(KafkaProduce.class);
    public KafkaTemplate<String,String> kafkaTemplate;

    public KafkaProduce(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message){
        logger.info(String.format("Message sent %s",message));
        kafkaTemplate.send("kafkaTest",message);
    }
}
