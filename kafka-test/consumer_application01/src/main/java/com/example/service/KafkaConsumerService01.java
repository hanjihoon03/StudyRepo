package com.example.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class KafkaConsumerService01 {

    // 이 메서드는 Kafka 메시지를 수신하는 리스너 역할을 한다.
    // topics 속성은 이 리스너가 구독할 토픽을 지정하고, groupId 속성은 Consumer 그룹 ID를 지정한다.
    // 이 리스너는 'test-topic'이라는 토픽의 메시지를 구독하며, Consumer 그룹 ID는 'consumer_group01'이다.
    @KafkaListener(topics = "test-topic", groupId = "consumer_group01")
    public void consume(String message) throws IOException {
        log.info("Consumed Message :{}", message);
    }
}
