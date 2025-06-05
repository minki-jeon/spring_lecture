package com.example.spring.dto;

import lombok.Data;

@Data
public class SuppliersDTO {
    private int id;
    private String name;
    private String contactName;
    private String address;
    private String city;
    private String postalCode;
    private String country;
    private String phone;
}
