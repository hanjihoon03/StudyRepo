package com.apidto;

import com.base.item.ClothesType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Data
@Schema(description = "Clothes request")
public class ClothesApiDto {
    private Long id;
    private String name;
    private int price;
    private int quantity;
    private ClothesType clothesType;
    private String brand;
    private int size;

    public ClothesApiDto() {
    }

    public ClothesApiDto(Long id, String name, int price, int quantity, ClothesType clothesType, String brand, int size) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.clothesType = clothesType;
        this.brand = brand;
        this.size = size;
    }
}
