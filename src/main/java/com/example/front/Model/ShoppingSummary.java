package com.example.front.Model;

import com.example.front.repository.PictureEntity;
import lombok.Builder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;
@Builder
public class ShoppingSummary {

    public long id;
    public String name;
    public int price;
    public int quantity;
    public int sumPrice;
    public int index;

    public ShoppingSummary() {
    }

    public ShoppingSummary(long id, String name, int price, int quantity, int sumPrice, int index) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.sumPrice = sumPrice;
        this.index = index;
    }
}
