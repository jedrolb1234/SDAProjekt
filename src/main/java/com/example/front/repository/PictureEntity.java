package com.example.front.repository;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pictures")
public class PictureEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch =  FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false) // Nazwa kolumny klucza obcego w tabeli Pictures
//    @MapsId
    private ProductEntity product;

    @Column(nullable = false)
    private String path;

    public PictureEntity(ProductEntity product, String path) {
        this.product = product;
        this.path = "'" + path + "'";
    }

    public PictureEntity() {
    }


    public ProductEntity getProduct() {
        return product;
    }

    public String getPath() {
        return path;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
