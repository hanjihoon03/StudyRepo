package com.base;

import com.base.item.Item;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Market {

    @Id @GeneratedValue
    @Column(name = "market_id")
    private Long id;

    private int orderQuantity; //주문 수량

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item items;

    public Market() {
    }

    public Market(int orderQuantity, User user, Item items) {
        this.orderQuantity = orderQuantity;
        this.user = user;
        this.items = items;
    }
}
