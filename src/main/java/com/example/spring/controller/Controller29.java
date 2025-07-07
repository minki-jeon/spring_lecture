package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/api/main29")
@ResponseBody
public class Controller29 {

    @PostMapping("sub1")
    public String sub1(){
        System.out.println("Controller29.sub1");

        return null;
    }
    @PostMapping("sub2")
    public String sub2(){
        System.out.println("Controller29.sub2");

        return null;
    }

    @PostMapping("sub3")
    public String sub3(){
        System.out.println("Controller29.sub3");

        return null;
    }

    @PostMapping("sub4")
    public String sub4(@RequestBody Map<String, Object> map){
        // @RequestBody : JSON을 해당 타입으로 역직렬화(Decoding, Parsing)
        System.out.println("Controller29.sub4");
        System.out.println("map = " + map);

        return null;
    }

    @PostMapping("sub5")
    public String sub5(@RequestBody Map<String, Object> map){
        System.out.println("Controller29.sub5");
        System.out.println("map = " + map); // {address=seoul, score=88.12, country=korea}

        return null;
    }

    @PostMapping("sub6")
    public String sub6(@RequestBody Map<String, Object> map){
        Object val1 = map.get("val1");
        Object val2 = map.get("val2");
        Object val3 = map.get("val3");
        Object val4 = map.get("val4");
        Object val5 = map.get("val5");
        Object val6 = map.get("val6");

        System.out.println("val1 = " + val1.getClass().getSimpleName());
        System.out.println("val2 = " + val2.getClass().getSimpleName());
        System.out.println("val3 = " + val3.getClass().getSimpleName());
        System.out.println("val4 = " + val4.getClass().getSimpleName());
        System.out.println("val5 = " + val5.getClass().getSimpleName());
        System.out.println("val6 = " + val6);   // null

        return null;
    }
}
