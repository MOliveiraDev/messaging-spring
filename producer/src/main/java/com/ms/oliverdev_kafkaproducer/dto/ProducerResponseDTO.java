package com.ms.oliverdev_kafkaproducer.dto;

import lombok.Builder;

@Builder
public record ProducerResponseDTO(String newMessage) {
}
