package com.project.service;

import com.base.Delivery;
import com.base.Purchase;
import com.base.User;
import com.dto.ItemDto;
import com.repository.PurchaseRepository;
import io.micrometer.core.annotation.Counted;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;

    /**
     * 결제 후 결제한 정보를 저장하기 위한 로직
     * @param item 사용자가 구매한 아이템
     * @param delivery 사용자의 배송 정보
     * @param user 사용자
     */
    @Counted("order.count")
    public void addPurchase(ItemDto item, Delivery delivery, User user) {
        Purchase purchase = new Purchase(
                item.getName(),
                item.getPrice(),
                item.getQuantity(),
                user,
                delivery
        );
        purchaseRepository.save(purchase);
    }




}
