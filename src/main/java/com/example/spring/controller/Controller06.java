package com.example.spring.controller;

import com.example.spring.dto.MyBean053;
import com.example.spring.dto.MyBean057;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("main6")
public class Controller06 {

    /*
     * (1) Model Attribute - Set
     * (2) Thymeleaf 반복 출력 th:each
     */
    @RequestMapping("sub1")
    public String sub1(Model model) {

        model.addAttribute("cars", Set.of("tesla", "uber", "waymo"));
        model.addAttribute("list", List.of("java", "spring", "react"));

        return "main6/sub1";
    }

    @RequestMapping("sub2")
    public String sub2(Model model) {

        model.addAttribute("aiList", List.of("chatgpt", "claude", "grok", "gemini"));
        model.addAttribute("mySet", Set.of("apple", "orange", "banana", "cherry"));

        return "main6/sub2";
    }

    /*
     * (3) Thymeleaf 반복 출력 th:each - ul>li
     */
    @RequestMapping("sub3")
    public String sub3(Model model) {

        model.addAttribute("people",
                List.of(new MyBean053(99.5, "donald", 10, true),
                        new MyBean053(88.4, "trump", 20, false),
                        new MyBean053(77.3, "musk", 30, true),
                        new MyBean053(66.2, "elon", 40, false)));

        return "main6/sub3";
    }

    /*
     * (4) Thymeleaf 반복 출력 th:each - table
     */
    @RequestMapping("sub4")
    public String sub4(Model model) {

        model.addAttribute("myList",
                List.of(new MyBean057("lee", "01-01", 5000),
                        new MyBean057("kim", "02-02", 4000),
                        new MyBean057("son", "03-03", 6000),
                        new MyBean057("park", "04-04", 3000),
                        new MyBean057("choi", "05-05", 7000)));

        return "main6/sub4";
    }
}
