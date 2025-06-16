package com.example.spring.controller;

import com.example.spring.entity.Entity14;
import com.example.spring.service.Service2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

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

    @GetMapping("sub5")
    public String sub5() {
        service2.process5();
        return "main20/sub5";
    }

    @GetMapping("sub6")
    public String sub6() {
        service2.process6();
        return "main20/sub6";
    }

    @GetMapping("sub10")
    public String sub10() {
        // Spring Data JPA
        // Entity : 테이블과 매핑되는 클래스(객체)
        // Repository : Entity를 이용한 CRUD 메소드 제공하는 Class / Interface
        //      SELECT Method : find~(), get~()
        //      UPDATE Method : save~()
        //      DELETE Method : delete~()
        //      INSERT Method : save~()

        // Repository 생성 : JpaRepository<T, ID> 인터페이스 상속받는 클래스를 생성
        // 타입파라미터 T: CRUD 대상 테이블에 매핑되는 Entity
        // 타입파라미터 ID : Entity의 PK 자료형

        //  Spring은 Repository 인터페이스에 있는 메소드를 활용하여 연결, statement, ResultSet 처리하는 구현 코드를 생성

        service2.process7();

        return "main20/sub10";

    }

    @GetMapping("sub11")
    public String sub11() {

        service2.process8();

        return "main20/sub11";
    }

    // 매핑되는 Table 없이 실행
    @GetMapping("sub12")
    public String sub12() {
        service2.process9();
        return "main20/sub12";
    }

    // Entity13, Entity13Repository, request handler method, srvice.process10(), findById() 호출 => Table 존재하지 않다는 메시지 확인
    @GetMapping("sub13")
    public String sub13() {
        service2.process10();
        return "main20/sub13";
    }

    @GetMapping("sub14")
    public String sub14(Integer id, Model model) {
        Entity14 data = service2.process11(id);

        model.addAttribute("data", data);
        System.out.println(data);
        return "main20/sub14";

    }

    // JPA INSERT
    // /main20/sub15?name=choi&score=88.9&city=dokdo
    @GetMapping("sub15")
    public String sub15(String name, Double score, String city) {
        service2.process12(name, score, city);
        return "main20/sub15";
    }

    // JPA INSERT
    // ?address=신촌&price=5678&inserted=2010-10-10T12:13:14
    @GetMapping("sub16")
    public String sub16(String address, Integer price, LocalDateTime inserted) {
        service2.process13(address, price, inserted);
        return "main20/sub16";
    }

    // JPA UPDATE
    @GetMapping("sub17")
    public String sub17(Integer id, Double score) {
        service2.process14(id, score);
        return "main20/sub17";
    }

    // JPA UPDATE
    // table15 UPDATE  /main20/sub18?id=1&address=강남
    @GetMapping("sub18")
    public String sub18(Integer id, String address) {
        service2.process15(id, address);
        return "main20/sub18";
    }

    // JPA DELETE
    @GetMapping("sub19")
    public String sub19(Integer id) {
        service2.process16(id);
        return "main20/sub19";
    }

    // JPA DELETE
    @GetMapping("sub20")
    public String sub20(Integer id) {
        service2.process17(id);
        return "main20/sub20";
    }
}
