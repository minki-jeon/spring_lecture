package com.example.spring.repository;

import com.example.spring.entity.Entity19;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Entity19Repository extends JpaRepository<Entity19, Integer> {
    // findById


    // SELECT * FROM product WHERE category_id = :categoryId
    List<Entity19> findByCategoryId(Integer categoryId);

    // SELECT * FROM product WHERE supplier_id = :supplierId
    List<Entity19> findBySupplierId(Integer supplierId);

    // SELECT * FROM product WHERE price BETWEEN :p1 AND :p2
    List<Entity19> findByPriceBetween(Double p1, Double p2);

    // SELECT * FROM product WHERE price >= :p1 AND price <= :p2
    List<Entity19> findByPriceGreaterThanEqualAndPriceLessThanEqual(Double p1, Double p2);

    // SELECT * FROM product WHERE price >= :price
    List<Entity19> findByPriceGreaterThanEqual(Double price);

    // SELECT * FROM product WHERE category_id IN (?, ?, ?, ..)
    List<Entity19> findByCategoryIdIn(List<Integer> categoryIds);

    // SELECT * FROM product WHERE product_name LIKE :keyword
    // with wildcard
    List<Entity19> findByProductNameLike(String productName);

    // SELECT * FROM product WHERE product_name LIKE :keyword
    // without wildcard
    List<Entity19> findByProductNameContains(String productName);
//    List<Entity19> findByProductNameContaining(String productName);       // Contains와 Containing 동일한 쿼리 생성

}