package com.example.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "my_table29", schema = "jpa")
public class Entity29 {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "first_name", length = 10)
    private String firstName;

    @Column(name = "last_name", length = 10)
    private String lastName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

}