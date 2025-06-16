package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="my_table2")
@Getter
@Setter
@ToString
public class Entity2 {
    @Id     // PK 역할
    @GeneratedValue(strategy=GenerationType.IDENTITY)   // AUTO_INCREMENT 역할
    Integer id;
    @Column(name = "name")
    String name;
    @Column(name = "address")
    String address;
    @Column(name = "city")
    String city;
}
