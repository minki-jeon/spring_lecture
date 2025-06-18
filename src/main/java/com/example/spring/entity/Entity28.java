package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "my_table28")
public class Entity28 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String productName;
    private Integer price;
    private String unit;

    // category_id (Foreign Key)
//    private Integer categoryId;
//    @OnoToMany      // 일대다(1:N)관계
    @ManyToOne          // 다대일(N:1)관계
    @JoinColumn(name = "category_id")   // Foreign Key
    private Entity27 category;


}
