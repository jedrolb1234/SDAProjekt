package com.example.front.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface AppRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findAll();
    @Query("SELECT e FROM ProductEntity e WHERE e.productId >= :product")
    Optional<ProductEntity> getProductRepositoryByProductId(int product);
    @Query(value = "select e from ProductEntity e where e.name = :name")
    Optional<ProductEntity> findByName(String name);

//    @Query(value = "select * from products e where e.price >= price1 and e.price <= price2")
//    Optional<ProductRepository> findByPrice(int price1, int price2);
    @Query("SELECT e FROM ProductEntity e WHERE e.price <= :price AND e.category = :category")

    List<ProductEntity> findProductsByPriceAndCategory(int price, int category);
    @Query("SELECT e FROM ProductEntity e WHERE e.category = :category")
    List<ProductEntity> findProductsByCategory(int category);
}