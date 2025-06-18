package com.example.spring.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "my_table26")
@Getter
@Setter
public class Entity26 {

    @EmbeddedId
    private Entity26Id id;

    private String author;
    private Integer price;
}
