package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/main28")
@Controller
public class Controller28 {

    @GetMapping("sub1")
    public String sub1() {
        System.out.println("Controller28.sub1");

        return null;
    }

    @PostMapping("sub2")
    public String sub2() {
        System.out.println("Controller28.sub2");
        return null;
    }

    @GetMapping("sub3")
    public String sub3() {
        System.out.println("Controller28.sub3");

        return null;
    }

    @PostMapping("sub4")
    public String sub4() {
        System.out.println("Controller28.sub4");
        return null;
    }
}
