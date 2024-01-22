package com.example.front.Repository;

import com.example.front.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface Repository extends JpaRepository<Product, Long> {

    List<Product> getAllProduct();
    Optional<Product> getProductByIsdn(long id);
    @Query(value = "select * from products e where e.name = name", nativeQuery = true)
    Optional<Product> findByName(String name);

    @Query(value = "select * from products e where e.price >= price1 and e.price <= price2", nativeQuery = true)
    Optional<Product> findByPrice(double price1, double price2);

}