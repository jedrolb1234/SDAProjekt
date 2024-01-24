package com.example.front.repository;

import javax.persistence.*;

@Entity
@Table(name = "pictures")
public class PictureEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch =  FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false) // Nazwa kolumny klucza obcego w tabeli Pictures
    private ProductEntity product;
    @Column(nullable = false)
    private String path;

    public PictureEntity(long id, ProductEntity product, String path) {
        this.id = id;
        this.product = product;
        this.path = path;
    }

    public PictureEntity() {
    }

    public long getId() {
        return id;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public String getPath() {
        return path;
    }


}
