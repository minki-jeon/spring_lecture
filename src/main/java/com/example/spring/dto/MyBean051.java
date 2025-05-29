package com.example.spring.dto;

import lombok.Data;

@Data
public class MyBean051 {
    private String name;
    private String address;
    private Integer age;

    // information (읽기전용) property
    public String getInformation() {
        return "My Name is " + name + ", My Address is " + address + ", My Age is " + age;
    }
}
