package com.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PurchasePayDto {
    private Long userId;
    private String itemName;
    private String total_price;
    private String quantity;
}
