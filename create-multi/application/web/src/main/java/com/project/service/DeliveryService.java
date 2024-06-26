package com.project.service;

import com.project.Delivery;
import com.project.User;
import com.project.subdomain.DeliveryStatus;
import com.project.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;

    /**
     * 구매한 아이템의 배송정보를 저장하기 위한 로직
     * @param user 구매한 유저객체
     * @return 저장한 배송정보 객체 반환
     */
    public Delivery addDelivery(User user) {

        Delivery delivery = new Delivery(
                user.getAddress(),
                DeliveryStatus.DELIVERY,
                LocalDateTime.now(),
                user
        );
        deliveryRepository.save(delivery);
        return delivery;
    }
}
