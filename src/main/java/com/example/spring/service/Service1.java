package com.example.spring.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//* Service 어노테이션에 Component 어노테이션 포함.
//@Component
@Service
public class Service1 {
    public String action1() {
        System.out.println("crud 작업. Business Logic 실행");
        return "결과값";
    }
}
