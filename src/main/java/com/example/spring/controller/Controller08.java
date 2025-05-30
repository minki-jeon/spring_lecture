package com.example.spring.controller;

import com.example.spring.dto.MyBean053;
import com.example.spring.dto.MyBean057;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("main8")
public class Controller08 {
    @RequestMapping("sub1")
    public String sub1(Model model) {

        model.addAttribute("students",
                List.of(new MyBean053(33.3, "trump",10, true),
                        new MyBean053(44.4, "donald", 20, false),
                        new MyBean053(55.5, "musk", 30, true),
                        new MyBean053(66.6, "elvis",40, false),
                        new MyBean053(77.7, "elon", 50, true)));

        return "main8/sub1";
    }

    @RequestMapping("sub2")
    public String sub2(Model model) {

        model.addAttribute("myList",
                List.of(new MyBean057("lee", "01-01", 5000),
                        new MyBean057("kim", "02-02", 4000),
                        new MyBean057("son", "03-03", 6000),
                        new MyBean057("park", "04-04", 3000),
                        new MyBean057("choi", "05-05", 7000)));

        return "main8/sub2";
    }
}
