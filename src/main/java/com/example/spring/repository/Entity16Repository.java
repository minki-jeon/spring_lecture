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
}