package com.ms.oliverdev_kafkaproducer.controller;

import com.ms.oliverdev_kafkaproducer.dto.ProducerRequestDTO;
import com.ms.oliverdev_kafkaproducer.dto.ProducerResponseDTO;
import com.ms.oliverdev_kafkaproducer.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping
    public ResponseEntity<ProducerResponseDTO> sendMessage(@RequestBody ProducerRequestDTO producerRequestDTO) {
        ProducerResponseDTO response = messageService.sendMessage(producerRequestDTO);
        return ResponseEntity.ok().body(response);
    }

}
