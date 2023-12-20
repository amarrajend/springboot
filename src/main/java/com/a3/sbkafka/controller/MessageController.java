package com.a3.sbkafka.controller;

import com.a3.sbkafka.kafka.KafkaProduce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    public KafkaProduce kafkaProduce;

    public MessageController(KafkaProduce kafkaProduce) {
        this.kafkaProduce = kafkaProduce;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        kafkaProduce.sendMessage(message);
        return ResponseEntity.ok("Message Sent to topic");
    }
}