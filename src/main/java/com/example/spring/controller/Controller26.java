package com.example.spring.controller;

import com.example.spring.dto.Entity36Dto;
import com.example.spring.dto.ProductInfo;
import com.example.spring.entity.Entity34;
import com.example.spring.entity.Entity36;
import com.example.spring.repository.Entity36Repository;
import com.example.spring.service.Service8;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("main26")
public class Controller26 {

    private final Service8 service8;
    private final Entity36Repository entity36Repository;

    // insert(34,35,36)
    @RequestMapping("sub1")
    public String sub1() {
        service8.action1();

        return "main26/sub1";
    }

    @RequestMapping("sub2")
    public String sub2() {
        // 두 명의 학생 (2개 record)
        // 두 개의 강의 (2개 lecture)
        // 각 학생이 하나의 강의 수강 (2개의 수강정보)
        service8.action2();
        return "main26/sub2";
    }

    // delete(36)
    @RequestMapping("sub3")
    public String sub3() {
        service8.action3();
        return "main26/sub3";
    }

    // delete(34,36)
    @RequestMapping("sub4")
    public String sub4() {
        service8.action4();
        return "main26/sub4";
    }

    @RequestMapping("sub5")
    public String sub5() {
        service8.action5();
        return "main26/sub5";
    }

    @RequestMapping("sub6")
    public String sub6() {
        service8.action6();
        return "main26/sub6";
    }

    @RequestMapping("sub7")
    public String sub7() {
        service8.action7();
        return "main26/sub7";
    }

    @RequestMapping("sub8")
    public String sub8() {
        Entity36 l1 = service8.action8();
        // return Entity36
        System.out.println(l1.getRegisteredAt());

        Entity34 s1 = l1.getStudent();
        // Exception(No Session) 메시지 발생 - Session 종료 (Service에서 트랜잭션이 종료되면서 DB Connection이 종료된 상태)
        String name = s1.getName();
        System.out.println("name = " + name);
        // 마찬가지로 view (Thymeleaf)에서도 요청 시, session 종료상태이므로 데이터를 받아올 수 없다.
        // * spring.jpa.open-in-view=true 해당 설정으로 해결할 수 있으나, 다른 문제가 발생될 수 있으므로 false로 권고한다.

        return "main26/sub8";
    }

    @RequestMapping("sub9")
    public String sub9() {
        Entity36Dto l1 = service8.action9();
        System.out.println(l1.getRegisteredAt());
        System.out.println("name = " + l1.getStudentName());

        return "main26/sub9";
    }

    @RequestMapping("sub10")
    public String sub10() {
        service8.action10();
        return "main26/sub10";
    }

    @RequestMapping("sub11")
    public String sub11() {
        List<ProductInfo> result = service8.action11();

        for (ProductInfo productInfo : result) {
            System.out.println("productInfo = " + productInfo.getId());
            System.out.println("productInfo = " + productInfo.getProductName());
            System.out.println("productInfo = " + productInfo.getPrice());
            System.out.println("productInfo = " + productInfo.getCategoryName());
            System.out.println();
        }

        return "main26/sub11";
    }
}
