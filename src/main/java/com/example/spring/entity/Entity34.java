package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@Entity
//@Table(name = "my_table34", schema = "jpa")
@Table(name = "my_table34")
@ToString
public class Entity34 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
    private Integer id;

//    @Column(name = "name", length = 30)
    private String name;

//    @Column(name = "birth_date")
    private LocalDate birthDate;

//    @Column(name = "info", length = 30)
    private String info;

}