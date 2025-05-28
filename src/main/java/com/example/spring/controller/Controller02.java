package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class Controller02 {

    // /main2/sub1?name
    @RequestMapping(value = "/main2/sub1", params = "name")
    public void sub1(WebRequest reqest) {
        // header 정보
        reqest.getHeader("User-Agent");

        System.out.println("Controller02.sub1");
    }

    // /main2/sub2?name&address
    //            ?{Query-String}
    // Query-String: name1=value1&name2=value2
    @RequestMapping(value = "/main2/sub1", params = {"name", "address"})
    public void sub2(WebRequest reqest) {
        // header 정보
        reqest.getHeader("User-Agent");

        System.out.println("Controller02.sub2");
    }
}
