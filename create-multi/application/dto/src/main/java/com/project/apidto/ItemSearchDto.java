package com.project.apidto;

import com.project.item.Book;
import com.project.item.Clothes;
import com.project.item.Electronics;
import com.project.item.Food;
import lombok.Data;


@Data
public class ItemSearchDto {
    private Long id;
    private String name;
    private int price;
    private int quantity;
    private Book book;
    private Food food;
    private Clothes clothes;
    private Electronics electronics;

    public ItemSearchDto() {

    }

    public ItemSearchDto(Long id, String name, int price, int quantity, Book book, Food food, Clothes clothes, Electronics electronics) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.book = book;
        this.food = food;
        this.clothes = clothes;
        this.electronics = electronics;
    }
}
