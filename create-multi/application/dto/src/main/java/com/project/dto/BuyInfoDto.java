package com.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuyInfoDto {
    private String zipcode;
    private String city;
    private String street;
    private LocalDateTime orderTime;
    private String quantity;
    private String totalAmount;
    private String item_name;
}
