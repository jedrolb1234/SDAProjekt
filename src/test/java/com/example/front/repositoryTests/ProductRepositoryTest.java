package com.example.front.repositoryTests;

import com.example.front.repository.AppRepository;
import com.example.front.repository.PictureEntity;
import com.example.front.repository.ProductEntity;
import jdk.dynalink.linker.support.Guards;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class ProductRepositoryTest {
    ProductEntity product;
    @Autowired
    private AppRepository repository;
    @BeforeEach
    public void setProduct() {

        List<PictureEntity> pictures = new ArrayList<>();
        PictureEntity picture = new PictureEntity();
        product = ProductEntity.builder()
                .brand("Dobry produkt")
                .description("Krótki opis.")
                .category(3)
                .name("Kijki")
                .numberOfPlayer(1)
                .size(40)
                .warranty(24)
                .price(30)
                .build();

        picture.setPath("/static/Img/Obrazy/art. szkolne/bidon/1.png");
        picture.setProduct(product);
        pictures.add(picture);
        product.setPicture(pictures);
    }
    @Test
    void assertThatReturnFullListOfProducts(){
        List<ProductEntity> products = repository.findAll();

        Assertions.assertEquals(products.size(), 51);
    }
    @Test
    void assertInsertionToDB(){
        repository.save(product);
        List<ProductEntity> products = repository.findAll();
        Assertions.assertEquals(products.size(), 52);
    }

    @Test
    void assertNumberOfPicturesIsTrue(){
    repository.save(product);
    List<ProductEntity> products = repository.findProductsByName(product.getName());
    Assertions.assertEquals(products.get(0).getPicture().size(), 1);
    }

    @Test
    void checkPriceLessThanGiven(){
        List<ProductEntity> products = repository.findProductsByPrice(50);
        List<ProductEntity> productLesThan50 = products.stream().filter(p -> p.getPrice() <= 50).collect(Collectors.toList());
        Assertions.assertEquals(products.size(), productLesThan50.size());
    }    @Test
    void checkProductsWithCategory(){
        List<ProductEntity> products = repository.findProductsByCategory(1);
        List<ProductEntity> productsFromDB = repository.findAll();
        List<ProductEntity> productCat1 = productsFromDB.stream().filter(p -> p.getCategory() == 1).collect(Collectors.toList());
        Assertions.assertEquals(products.size(), productCat1.size());
    }
    @Test
    void checkProductWithPriceAndCategory(){
        List<ProductEntity> products = repository.findProductsByPriceAndCategory(50, 1);
        List<ProductEntity> productsFromDB = repository.findAll();
        List<ProductEntity> productCat1 = productsFromDB.stream().filter(p -> p.getCategory() == 1 && p.getPrice() <= 50).collect(Collectors.toList());
        Assertions.assertEquals(products.size(), productCat1.size());
    }
    @Test
    void checkProductsWithNameAndPrice(){
        List<ProductEntity> products = repository.findProductsByNameAndPrice("lalka", 80);
        List<ProductEntity> productsFromDB = repository.findAll();
        List<ProductEntity> productCat1 = productsFromDB.stream().filter(p -> p.getName().contains("Lalka") && p.getPrice() <= 80).collect(Collectors.toList());
        Assertions.assertEquals(products.size(), productCat1.size());
    }
    @Test
    void checkProductsWithNameAndCategory(){
        List<ProductEntity> products = repository.findProductsByNameAndCategory("lalka", 3);
        List<ProductEntity> productsFromDB = repository.findAll();
        List<ProductEntity> productCat1 = productsFromDB.stream().filter(p -> p.getName().contains("Lalka") && p.getCategory() == 3).collect(Collectors.toList());
        Assertions.assertEquals(products.size(), productCat1.size());
    }
    @Test
    void checkProductsWithNamePriceAndAndCategory(){
        List<ProductEntity> products = repository.findProductsByNameAndPriceAndCategory("lalka",100 ,3);
        List<ProductEntity> productsFromDB = repository.findAll();
        List<ProductEntity> productCat1 = productsFromDB.stream().filter(p -> p.getName().contains("Lalka") && p.getCategory() == 3 &&p.getPrice() <= 100).collect(Collectors.toList());
        Assertions.assertEquals(products.size(), productCat1.size());
    }



}
