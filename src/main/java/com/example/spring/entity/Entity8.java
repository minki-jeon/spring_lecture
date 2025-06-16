package com.example.spring.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "my_table8")
public class Entity8 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String address;

    private Double salary;

    private LocalDateTime insertedAt;

    private LocalDate hireDate;

}

/*
// Entity -> SQL 자동생성
CREATE TABLE my_table8
(
id INT AUTO_INCREMENT PRIMARY KEY,
address VARCHAR(23),
salary DECIMAL(10, 2),
inserted_at DATETIME,
hire_date DATE
 */