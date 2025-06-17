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

    // SQL : Table 대상으로 작성
    /*
    @Query(value = """
            SELECT *
            FROM jpa.customer
            WHERE country = :country
            """, nativeQuery = true)
     */
    // JPQL : Entity 대상으로 작성
    //    @Query(value = """ """, nativeQuery = false)  // nativeQuery = false : Default
    @Query("""
            SELECT e
            FROM Entity16 e
            WHERE e.country = :country
            """)
    List<Entity16> query5(String country);

    // 도시 이름으로 고객 조회하는 쿼리 JPQL로 작성
    @Query("""
            SELECT e 
            FROM Entity16 e
            WHERE e.city = :city
            """)
    List<Entity16> query6(String city);

    //
    @Query("""
            SELECT c
            FROM Entity16 c
            WHERE c.customerName LIKE :keyword
            """)
    List<Entity16> query7(String keyword);


}