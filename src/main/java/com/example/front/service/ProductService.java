package com.example.front.service;

import com.example.front.repository.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductEntity> getAllProduct();

    Optional<ProductEntity> getProductByProductId(int productId);

    Optional<ProductEntity> getByName(String name);

    List<ProductEntity> getByPriceAndCategory(int price1, int category);
    List<ProductEntity> getByCategory(int category);

}
