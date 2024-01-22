package com.example.front.Service;

import com.example.front.Model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProduct();

    Optional<Product> getProductByIsdn(long isdn);

    Optional<Product> getByName(String name);

    Optional<Product> getByPrice(double price1, double price2);

}
