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
    private Integer id;
    // 클래스의 field명과 table의 컬럼명이 동일하다면 @Column 생략 가능
//    @Column(name="email")
    private String email;
//    @Column(name="info")
    private String info;
//    @Column(name="nick")
    private String nick;
    private String country;

    // lowerCamelCase
//    private String home_address;
//    @Column(name = "home_address")
    private String homeAddress;

    private String workAddress;
}
