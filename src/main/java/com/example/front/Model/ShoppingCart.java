package com.example.front.Model;

import com.example.front.repository.ProductEntity;

public class ShoppingCart {
    private int product;
    private int quantity;

    public ShoppingCart() {
    }

    public ShoppingCart(int product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
