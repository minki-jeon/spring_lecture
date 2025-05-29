package com.example.spring.dto;

import lombok.ToString;

@ToString
public class MyBean037 {
    // field: name, address, pw
    // property(Getter/Setter Method): name, address, password
    // *Property 이름은 getter, setter에 의해 결정
    private String name;
    private String address;
    private String pw;          // password

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

    public String getPassword() {
        return pw;
    }

    public void setPassword(String pw) {
        this.pw = pw;
    }
}
