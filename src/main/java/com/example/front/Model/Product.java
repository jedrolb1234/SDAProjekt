package com.example.front.Model;

import java.util.Objects;

public class Product {
    private final int isdn;
    private final  String name;
    private final String description;
    private final double price;
    private final int picture;
    private final int size;
    private final String brand;
    private final int numberOfPlayer;

    public Product(int isdn, String name, String description, double price, int picture, int size, String brand, int numberOfPlayer) {
        this.isdn = isdn;
        this.name = name;
        this.description = description;
        this.price = price;
        this.picture = picture;
        this.size = size;
        this.brand = brand;
        this.numberOfPlayer = numberOfPlayer;
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

    public double getPrice() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return isdn == product.isdn && price == product.price && picture == product.picture && size == product.size && numberOfPlayer == product.numberOfPlayer && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(brand, product.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isdn, name, description, price, picture, size, brand, numberOfPlayer);
    }

    @Override
    public String toString() {
        return "Product{" +
                "isdn=" + isdn +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", picture=" + picture +
                ", size=" + size +
                ", brand='" + brand + '\'' +
                ", numberOfPlayer=" + numberOfPlayer +
                '}';
    }
}
