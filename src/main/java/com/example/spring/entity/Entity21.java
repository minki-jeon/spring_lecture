package com.example.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "my_table21", schema = "jpa")
@ToString
public class Entity21 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "address", length = 20)
    private String address;

    // insertable=false, updatable=false : 해당 Column을 insert/false를 jpa에서 동작처리하지 않는다. DB에서 처리하도록 되므로
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "inserted_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime insertedAt;

}