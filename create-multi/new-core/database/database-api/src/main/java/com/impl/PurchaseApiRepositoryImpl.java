package com.impl;

import com.apidto.UserPurchaseDto;
import com.custom.PurchaseApiRepositoryCustom;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.base.QDelivery.delivery;
import static com.base.QPurchase.purchase;
import static com.base.QUser.user;


@Repository
public class PurchaseApiRepositoryImpl implements PurchaseApiRepositoryCustom {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;
    public PurchaseApiRepositoryImpl(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    /**
     * user가 구매를 완료한 구매 완료 정보를 반환합니다.
     * @param id 구매 목록을 가진 user의 id
     * @return 구매 정보들의 list
     */
    @Override
    public List<UserPurchaseDto> purchaseList(Long id) {
        return queryFactory.select(Projections.constructor(UserPurchaseDto.class,
                purchase.user.id,
                delivery.orderTime,
                delivery.address,
                purchase.itemName,
                purchase.orderPrice,
                purchase.orderQuantity
                ))
                .from(purchase)
                .innerJoin(purchase.delivery,delivery)
                .innerJoin(purchase.user,user)
                .where(purchase.user.id.eq(id))
                .fetch();
    }
}
