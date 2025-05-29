package com.example.spring.controller;

import com.example.spring.dto.MyBean031;
import com.example.spring.dto.MyBean032;
import com.example.spring.dto.MyBean033;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
/*
 * (1) @RequestMapping 클래스 바인딩으로 모든 메소드의 경로 앞에 공통 적용
 */
@RequestMapping("main3")
public class Controller03 {

    // http://localhost:8080/main3/sub1
    @RequestMapping("sub1")
    public void sub1() {
        System.out.println("Controller03.sub1");
    }

    @RequestMapping("sub2")
    public void sub2() {
        System.out.println("Controller03.sub2");
    }

    @RequestMapping("sub3")
    public void sub3() {
        System.out.println("Controller03.sub3");
    }

    /*
     * (2) RequestParam
     */
    // /main3/sub4?param1=val1&param2=val2
    @RequestMapping("sub4")
    public void sub4(@RequestParam("param1") String param1,
                     @RequestParam("param2") String param2) {
        System.out.println("param1 = " + param1);
        System.out.println("param2 = " + param2);
    }

    // /main3/sub5?address=seoul&age=44&email=gmail&home=dokdo&city=ny&name=donald
    @RequestMapping("sub5")
    public void sub5(@RequestParam Map<String, String> params) {
        for (Map.Entry<String, String> entry : params.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    /*
     * (3) JavaBeans (DTO)
     */
    // request parameter를 java beans (DTO; Data Transaction Object)으로 받기
    // /main3/sub6?name=donald&address=la
    // /main3/sub6?name=donald
    // /main3/sub6?address=ny
    @RequestMapping("sub6")
    public static void sub6(MyBean031 params) {
        System.out.println("params.getName() = " + params.getName());
        System.out.println("params.getAddress() = " + params.getAddress());
    }

    // /main3/sub7?name=musk&company=tesla&home=texas
    // /main3/sub7?name=musk&company=tesla&age=55
    @RequestMapping("sub7")
    public static void sub7(MyBean032 params) {
        System.out.println(params);
//        System.out.println("params.getName() = " + params.getName());
//        System.out.println("params.company() = " + params.getCompany());
//        System.out.println("params.getHome() = " + params.getHome());
    }

    /*
     * (4) Lombok
     */
    // /main3/sub8?nickName=trump&age=55&address=ny&score=98.99
    @RequestMapping("sub8")
    public void sub8(MyBean033 params) {
        System.out.println(params);
    }


}
