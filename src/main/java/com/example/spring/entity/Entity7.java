package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "my_table7", schema = "jpa")
public class Entity7 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "password", length = 30)
    private String password;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "nickname", length = 30)
    private String nickname;

    @Column(name = "point")
    private Long point;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "status", length = 10)
    private String status;

    @Column(name = "login_count")
    private Integer loginCount;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "session_id", length = 50)
    private String sessionId;

    @Column(name = "use_yn", length = 1)
    private String useYn;

    @Column(name = "del_yn", length = 1)
    private String delYn;

}