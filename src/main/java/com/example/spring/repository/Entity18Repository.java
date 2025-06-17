package com.example.spring.repository;

import com.example.spring.entity.Entity18;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Entity18Repository extends JpaRepository<Entity18, Integer> {
    // * 쿼리 생성 방법
    // findById
    // save
    // deleteById

    // SQL
    // JPQL

    // Query Method : 메소드 이름으로 쿼리만들기

    /*
    SELECT * FROM supplier WHERE country = :country
     */
    List<Entity18> findByCountry(String country);

    /*
    SELECT * FROM supplier WHERE city = :city
     */
    List<Entity18> findByCity(String city);

    /*
    SELECT * FROM supplier WHERE supplier_name LIKE :keyword
     */
    // keyword = "%"+keyword+"%" (와일드카드(%) 결합 필요)
    List<Entity18> findBySupplierNameLike(String keyword);

    /*
    SELECT * FROM supplier WHERE supplier_name LIKE :keyword
     */
    // keyword = keyword (와일드카드(%) 불필요)
    List<Entity18> findBySupplierNameContains(String keyword);

    /*
    SELECT * FROM supplier WHERE country IN (?, ?, ?)
     */
    List<Entity18> findByCountryIn(List<String> country);


    // SELECT * FROM supplier WHERE country IN (?, ?, ?) ORDER BY supplier_name
    List<Entity18> findByCountryInOrderBySupplierName(List<String> country);

    // SELECT * FROM supplier WHERE supplier_name LIKE :keyword ORDER BY supplier_name DESC
    List<Entity18> findBySupplierNameLikeOrderBySupplierNameDesc(String keyword);

}