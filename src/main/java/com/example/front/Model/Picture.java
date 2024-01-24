package com.example.front.Model;

import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Picture {

    private final long id;

    private final long productId;
    private final String path;
    public long getId() {
        return id;
    }

    public long getProductId() {
        return productId;
    }

    public String getPath() {
        return path;
    }

    public Picture(long id, long productId, String path) {
        this.id = id;
        this.productId = productId;
        this.path = path;
    }

}
