package com.example.spring.controller;

import com.example.spring.service.Service1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//* Controller 어노테이션에 Component 어노테이션 포함
@Controller
@RequestMapping("main19")
@RequiredArgsConstructor
public class Controller19 {

    private final Service1 service1;

    @GetMapping("sub1")
    public String sub1(Model model) {
        String result = service1.action1();

        model.addAttribute("data", result);

        return "main19/sub1";
    }

}
