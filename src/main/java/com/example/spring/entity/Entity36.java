package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@Entity
//@Table(name = "my_table36", schema = "jpa")
@Table(name = "my_table36")
@ToString
public class Entity36 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
    private Integer id;

//    @Column(name = "registered_at")
    private LocalDate registeredAt;

//    @Column(name = "enabled", length = 1)
    private String enabled;

//    @Column(name = "money", length = 1)
    private String money;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ManyToOne
//    @JoinColumn(name = "student_id", nullable = false)
    @JoinColumn
    private Entity34 student;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ManyToOne
//    @JoinColumn(name = "lecture_id", nullable = false)
    @JoinColumn
    private Entity35 lecture;

}