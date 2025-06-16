package com.example.spring.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "my_table9")
public class Entity9 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String password;
    private String name;
    private String nickname;
    private Long point;
    private Double exp;
    private Character gender;
    private LocalDate birthDate;
    private String status;
    private Integer loginCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String sessionId;
    private Character useYn;
    private Character delYn;
}
