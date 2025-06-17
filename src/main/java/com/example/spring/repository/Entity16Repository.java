package com.example.spring.repository;

import com.example.spring.entity.Entity16;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Entity16Repository extends JpaRepository<Entity16, Integer> {
    // findById
    // save
    // deleteById


    // 직접 만드는 쿼리
    @Query(value = """
            SELECT *
            FROM jpa.customer
            WHERE country = :country
            """, nativeQuery = true)
    List<Entity16> query1(String country);

    @Query(value = """
            SELECT *
            FROM jpa.customer
            WHERE city = :city
            """, nativeQuery = true)
    List<Entity16> query2(String city);

    @Query(value = """
            SELECT *
            FROM jpa.customer
            WHERE city = :city1
               OR city = :city2
            """, nativeQuery = true)
    List<Entity16> query3(String city1, String city2);

    @Query(value = """
            select *
            FROM jpa.customer
            WHERE customer_name LIKE :keyword
            """, nativeQuery = true)
    List<Entity16> query4(String keyword);
}