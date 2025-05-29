package com.example.spring.dto;

// JavaBean
public class MyBean031 {
    // private field
    private String name;
    private String address;

    // parameter 없는 생성자 (기본생성자)
//    public MyBean031() {
//    }


    // getters, setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
