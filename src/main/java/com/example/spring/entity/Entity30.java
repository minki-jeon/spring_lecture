package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "my_table30")
@Setter
@Getter
@ToString
public class Entity30 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate orderDate;
    private String info;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Entity29 employee;

}
