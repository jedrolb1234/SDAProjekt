package com.example.front.Service.Impl;

import com.example.front.Model.Product;
import com.example.front.Repository.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl {

    private final Repository repository;

    public ProductServiceImpl(Repository repository) {
        this.repository = repository;
    }

    List<Product> getAllProduct(){
        return repository.findAll();
    };
    Optional<Product> getProductByIsdn(long isdn){
        return repository.findById(isdn);
    };
    Optional<Product> getByName(String name){
        return repository.findByName(name);
    }
    Optional<Product> getByPrice(int price1, double price2){
        return repository.findByPrice(price1, price2);
    }

}
