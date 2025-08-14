package com.ms.oliverdev_kafkaproducer.service;

import com.ms.oliverdev_kafkaproducer.dto.ProducerRequestDTO;
import com.ms.oliverdev_kafkaproducer.dto.ProducerResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class MessageService {

    private static final Logger logger = Logger.getLogger(MessageService.class.getName());

    @Value("${topic.nome-topico}")
    private String nomeTopico;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public ProducerResponseDTO sendMessage(ProducerRequestDTO producerRequestDTO) {
        logger.info("Message as send to consumer: " + producerRequestDTO.message());
        this.kafkaTemplate.send(nomeTopico, producerRequestDTO.message());
        return new ProducerResponseDTO(producerRequestDTO.message());
    }

}
