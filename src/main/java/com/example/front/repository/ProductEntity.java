package com.example.front.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(length = 10000)
    private String description;
    private int price;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PictureEntity> picture; // = new HashSet<>();
    private int size;
    private String brand;
    private int numberOfPlayer;
    private int warranty;
    private int category;


    public ProductEntity(String name, String description, int price, List<PictureEntity> picture,
                         int size, String brand, int numberOfPlayer, int warranty, int category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.picture = picture;
        this.size = size;
        this.brand = brand;
        this.numberOfPlayer = numberOfPlayer;
        this.warranty = warranty;
        this.category = category;
    }

    public ProductEntity() {
    }
    public void setId(long id) {
        this.id = id;
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

    public void setPicture(List<PictureEntity> picture) {
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

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public List<PictureEntity> getPicture() {
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

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}

/*
Kategorie :
1 - Artykuły szkolne
2 - Gry
3 - Lalki
4 - Maskotki
5 - Pozostałe
6 - puzzle
7 - Samochody
9 - Zabawki do kąpieli
10 - Zabawki edukacyjne
11 - Zabawki ogrodowe
12 - Zabawki plastyczne
*/
