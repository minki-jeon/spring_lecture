package com.example.spring.dto;

import lombok.Data;

@Data
public class ProductsDTO {
    private Integer id;
    private String name;
    private Integer supplier;
    private Integer category;
    private String unit;
    private Double price;
}
