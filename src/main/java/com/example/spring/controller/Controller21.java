package com.example.spring.controller;

import com.example.spring.service.Service3;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
@RequestMapping("main21")
public class Controller21 {

    private final Service3 service3;

    @GetMapping("sub1")
    public String sub1() {
        service3.action1();

        return "main21/sub1";
    }

    @GetMapping("sub2")
    public String sub2() {
        service3.action2();
        return "main21/sub2";
    }

    @GetMapping("sub3")
    public String sub3() {
        service3.action3();
        return "main21/sub3";
    }

    // /main21/sub4?country=mexico
    @GetMapping("sub4")
    public String sub4(String country) {
        service3.action4(country);

        return "main21/sub4";
    }

    // /main21/sub4?city=berlin
    // service3.action5()
    // entity16Repository.query2()
    @GetMapping("sub5")
    public String sub5(String city) {
        service3.action5(city);

        return "main21/sub4";
    }

    // /main21/sub6?city1=london&city2=berlin
    @GetMapping("sub6")
    public String sub6(String city1, String city2) {
        service3.action6(city1, city2);

        return "main21/sub6";
    }

    // /main21/sub7?start=1950-01-01&end=1959-12-31
    // controller.sub7()
    // service.action7()
    // entity17repository.query1()
    // SELECT * FROM employee WHERE birth_date BETWEEN :start AND :end
    @GetMapping("sub7")
    public String sub7(LocalDate start, LocalDate end) {
        service3.action7(start, end);
        return "main21/sub7";
    }

    // /main21/sub8?keyword=fred
    // 고객 이름에 fred 포함된 고객들 조회
    @GetMapping("sub8")
    public String sub8(String keyword) {
        service3.action8(keyword);

        return "main21/sub8";
    }

    // /main21/sub9?keyword=an
    // 직원 이름에 an이 포함된 직원들 조회
    @GetMapping("sub9")
    public String sub9(String keyword) {
        service3.action9(keyword);
        return "main21/sub9";
    }

    // /main21/sub10?country=uk
    @GetMapping("sub10")
    public String sub10(String country) {
        service3.action10(country);
        return "main21/sub10";
    }

    @GetMapping("sub11")
    public String sub11(String city) {
        service3.action11(city);
        return "main21/sub11";
    }

    @GetMapping("sub12")
    public String sub12(String keyword) {
        service3.action12(keyword);
        return "main21/sub12";
    }

    @GetMapping("sub13")
    public String sub13(String keyword) {
        service3.action13(keyword);
        return "main21/sub13";
    }

}
