package com.project.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.project.Delivery;
import com.project.dto.BuyInfoDto;
import com.project.pay.KakaoPayApprovalV0;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public void serialization_SendMessage(Delivery delivery, KakaoPayApprovalV0 kakaoPayApprovalV0, int total_price) throws JsonProcessingException {

        String totalPrice = Integer.toString(total_price);
        BuyInfoDto buyInfoDto = new BuyInfoDto(
                delivery.getAddress().getZipcode(),
                delivery.getAddress().getCity(),
                delivery.getAddress().getStreet(),
                delivery.getOrderTime(),
                kakaoPayApprovalV0.getQuantity().toString(),
                totalPrice,
                kakaoPayApprovalV0.getItem_name()
        );
        objectMapper.registerModule(new JavaTimeModule());
        String message = objectMapper.writeValueAsString(buyInfoDto);

        kafkaTemplate.send("application-delivery",message);
    }
}
