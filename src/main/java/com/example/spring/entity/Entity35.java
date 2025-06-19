package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
//@Table(name = "my_table35", schema = "jpa")
@Table(name = "my_table35")
@ToString
public class Entity35 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
    private Integer id;

//    @Column(name = "lecture_title", length = 30)
    private String lectureTitle;

//    @Column(name = "info", length = 50)
    private String info;

//    @Column(name = "place", length = 50)
    private String place;

}