package com.example.spring.dto;

import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.spring.entity.Entity39}
 */
@Data
public class Entity39Dto implements Serializable {
    Integer id;
    String name;
    Integer price;
    String categoryName;
}