package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="my_table3")
@Getter
@Setter
@ToString
public class Entity3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name="email")
    String email;

    @Column(name="info")
    String info;

    @Column(name="nick")
    String nick;

}
