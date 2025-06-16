package com.example.spring.controller;

import com.example.spring.service.Service2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main20")
@RequiredArgsConstructor
public class Controller20 {

    private final Service2 service2;

    @GetMapping("sub1")
    public String sub1() {
        service2.process1();

        return "main20/sub1";
    }

    @GetMapping("sub2")
    public String sub2() {
        service2.process2();

        return "main20/sub2";
    }

    @GetMapping("sub3")
    public String sub3() {
        service2.process3();

        return "main20/sub3";
    }

    @GetMapping("sub4")
    public String sub4() {
        service2.process4();
        return "main20/sub4";
    }
}
