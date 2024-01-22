package com.example.front.Repository;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class ProductRepository {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int isdn;
    private  String name;
    private String description;
    private int price;
    private int picture;
    private int size;
    private String brand;
    private int numberOfPlayer;
    private int warranty;


    public ProductRepository(int isdn, String name, String description, int price, int picture, int size, String brand, int numberOfPlayer, int warranty) {
        this.isdn = isdn;
        this.name = name;
        this.description = description;
        this.price = price;
        this.picture = picture;
        this.size = size;
        this.brand = brand;
        this.numberOfPlayer = numberOfPlayer;
        this.warranty = warranty;
    }

    public ProductRepository() {

    }

    public void setId(long id) {
        this.id = id;
    }

    public void setIsdn(int isdn) {
        this.isdn = isdn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setNumberOfPlayer(int numberOfPlayer) {
        this.numberOfPlayer = numberOfPlayer;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    public long getId() {
        return id;
    }

    public int getIsdn() {
        return isdn;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public int getPicture() {
        return picture;
    }

    public int getSize() {
        return size;
    }

    public String getBrand() {
        return brand;
    }

    public int getNumberOfPlayer() {
        return numberOfPlayer;
    }

    public int getWarranty() {
        return warranty;
    }
}
