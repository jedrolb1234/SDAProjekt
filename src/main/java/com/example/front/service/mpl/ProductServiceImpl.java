package com.example.front.service.mpl;

import com.example.front.repository.AppRepository;

import com.example.front.repository.ProductEntity;
import com.example.front.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final AppRepository repository;

    public ProductServiceImpl(AppRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductEntity> getAllProduct(){
        return repository.findAll();
    };
    @Override
    public Optional<ProductEntity> getProductByProductId(int productId){
        return repository.findAll()
                .stream()
                .filter(product -> product.getProductId() == productId)
                .findFirst();
            };
    @Override
    public Optional<ProductEntity> getByName(String name){
        return repository.findByName(name);
    }

    @Override
    public List<ProductEntity> getByPriceAndCategory(int price, int category){
        return repository.findProductsByPriceAndCategory(price, category);
    }
    @Override
    public List<ProductEntity> getByCategory(int category){
        return repository.findProductsByCategory(category);
    }

}
