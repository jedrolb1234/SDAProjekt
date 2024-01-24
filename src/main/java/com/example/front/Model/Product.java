package com.example.front.Model;

import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

public class Product {

    private final int productId;
    private final  String name;
    private final String description;
    private final double price;
    private final int size;
    private final String brand;
    private final int numberOfPlayer;
    private final int category;
    @OneToMany(mappedBy = "product")
    private final List<Picture> picture;
    public Product(int productId, String name, String description, double price, List<Picture> picture, int size, String brand, int numberOfPlayer, int category) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.picture = picture;
        this.size = size;
        this.brand = brand;
        this.numberOfPlayer = numberOfPlayer;
        this.category = category;
    }

    public int getProductId() {
        return productId;
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

    public List<Picture> getPicture() {
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

    public int getCategory() {
        return category;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId && price == product.price && picture == product.picture && size == product.size && numberOfPlayer == product.numberOfPlayer && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(brand, product.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, name, description, price, picture, size, brand, numberOfPlayer);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
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
