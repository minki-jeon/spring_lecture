package com.example.spring.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "my_table13")
public class Entity13 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String country;

}
