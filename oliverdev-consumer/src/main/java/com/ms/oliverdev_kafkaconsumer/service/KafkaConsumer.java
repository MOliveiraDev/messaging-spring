package com.ms.oliverdev_kafkaconsumer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private final Logger logger = Logger.getLogger(KafkaConsumer.class.getName());

    @KafkaListener(topics = "${topic.nome-topico}", groupId = "group_id")
    public void consume(String message) throws IOException {
        logger.info("Message recebida: " + message);
    }
}
