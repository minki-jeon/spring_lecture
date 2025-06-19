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

    // insertable=false, updatable=false : DB에서 자동 처리되는 컬럼 명시, 해당 컬럼은 Insert/Update 할 때 jpa에서 처리하지 않는다. (PK는 별개)
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "inserted_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime insertedAt;

}