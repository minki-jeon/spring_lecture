package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main10")
public class Controller10 {
    @RequestMapping("sub1")
    public String sub1() {

        return "main10/sub1";
    }

    @RequestMapping("sub2")
    public String sub2(String name, String city) {
        System.out.println("name = " + name);
        System.out.println("city = " + city);

        return "main10/sub1";
    }
}
