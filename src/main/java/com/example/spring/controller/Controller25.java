package com.example.spring.controller;

import com.example.spring.service.Service7;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("main25")
public class Controller25 {

    private final Service7 service7;

    @RequestMapping("sub1")
    public String sub1() {
        service7.action1();
        return "main25/sub1";
    }

    @RequestMapping("sub2")
    public String sub2() {
        service7.action2();
        return "main25/sub2";
    }
}
