package com.apidto.update;

import com.base.item.ClothesType;
import lombok.Data;


/**
 * Clothes를 수정하기 위한 DTO
 */
@Data
public class UpdateClothesDto {
    private String name;
    private int price;
    private int quantity;
    private ClothesType clothesType;
    private String brand;
    private int size;
}
