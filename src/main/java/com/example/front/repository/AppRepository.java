package com.example.front.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface AppRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findAll();
    @Query("SELECT e FROM ProductEntity e WHERE e.id = :product")
    Optional<ProductEntity> getProductRepositoryByProductId(long product);
    @Query(value = "select e from ProductEntity e where e.name = :name")
    Optional<ProductEntity> findByName(String name);
    @Query("SELECT e FROM ProductEntity e WHERE e.price <= :price")
    List<ProductEntity> findProductsByPrice(int price);
    @Query("SELECT e FROM ProductEntity e WHERE e.price <= :price AND e.category = :category")
    List<ProductEntity> findProductsByPriceAndCategory(int price, int category);
    @Query("SELECT e FROM ProductEntity e WHERE e.category = :category")
    List<ProductEntity> findProductsByCategory(int category);
    @Query("SELECT e FROM ProductEntity e WHERE e.name LIKE %:name%")
    List<ProductEntity> findProductsByName(String name);

}