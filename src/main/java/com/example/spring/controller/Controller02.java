package com.example.spring.controller;

import org.apache.catalina.connector.RequestFacade;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.StandardServletAsyncWebRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@Controller
public class Controller02 {

    /*
     * (1) @RequestMapping - params 1개
     * */
    // /main2/sub1?name
    @RequestMapping(value = "/main2/sub1", params = "name")
    public void sub1(WebRequest request) {
        // header 정보
        request.getHeader("User-Agent");

        System.out.println("Controller02.sub1");
    }

    /*
     * (2) @RequestMapping - params 2개이상
     * */
    // /main2/sub2?name&address
    //            ?{Query-String}
    // Query-String: name1=value1&name2=value2
    @RequestMapping(value = "/main2/sub1", params = {"name", "address"})
    public void sub2(WebRequest request) {
        System.out.println("Controller02.sub2");
    }

    /*
     * (3) @RequestMapping - 동일한 path + 다른 params으로 서로 다른 Method 실행
     * */
    // /main2/sub3?name=musk
    @RequestMapping(value = "/main2/sub3", params = "name")
    public void sub3(WebRequest request) {
        String name = request.getParameter("name");
        System.out.println("name = " + name);

        System.out.println("Controller02.sub3");
    }

    // /main2/sub3?address=seoul
    // /main2/sub3?address=jeju
    @RequestMapping(value = "/main2/sub3", params = "address")
    public void sub4(WebRequest request) {
        String address = request.getParameter("address");
        System.out.println("address = " + address);

        System.out.println("Controller02.sub4");
    }

    /*
     * (4) @RequestParam
     * */
    // @RequestParam({REQUEST-PARAM} {VARIABLE}) : 해당 이름의 request parameter를 method parameter에 binding
    // /main2/sub5?email=gmail
    @RequestMapping(value = "/main2/sub5", params = "email")
    public void sub5(@RequestParam("email") String str) {
        System.out.println("str = " + str);
    }

    // /main2/sub6?email=yahoo&age=55
    @RequestMapping(value = "/main2/sub6", params = {"email", "age"})
    public void sub6(@RequestParam("email") String str,
                     @RequestParam("age") String v) {
        System.out.println("str = " + str);
        System.out.println("v = " + v);
    }

    /*
     * (5) @RequestParam - @RequestMapping (params 생략)
     * */
    // /main2/sub7?email=yahoo&age=55
    @RequestMapping(value = "/main2/sub7")
    public void sub7(@RequestParam("email") String str,
                     @RequestParam("age") String v) {
        System.out.println("str = " + str);
        System.out.println("v = " + v);
    }

    // /main2/sub8?address=jeju&country=korea&city=gangnam
    @RequestMapping(value = "/main2/sub8")
    public void sub8(@RequestParam("address") String addr,
                     @RequestParam("country") String country,
                     @RequestParam("city") String city) {
        System.out.println("addr = " + addr);
        System.out.println("country = " + country);
        System.out.println("city = " + city);
    }

    // /main2/sub9?city=seoul&age=44
    @RequestMapping(value = "/main2/sub9")
    public void sub9(@RequestParam("city") String city,
                     @RequestParam("age") String age) {
        System.out.println("city = " + city);
        System.out.println("age = " + age);
        int i = Integer.parseInt(age);
        System.out.println("i = " + i);
    }

    /*
     * (6) @RequestParam - ParamType 자동형변환
     * */
    // String -> int 자동형변환
    // /main2/sub10?city=seoul&age=44
    @RequestMapping(value = "/main2/sub10")
    public void sub10(@RequestParam("city") String city,
                      @RequestParam("age") int age) {
        System.out.println("city = " + city);
        System.out.println("age = " + age);
    }

    /*
     * (7) @RequestParam - (value) 생략
     * */
    // request parameter의 이름이 method parameter와 같으면
    // @RequestParam의 value 속성을 생략 가능
    // /main2/sub11?city=seoul&age=44
    @RequestMapping(value = "/main2/sub11")
    public void sub11(@RequestParam String city,
                      @RequestParam int age) {
        System.out.println("city = " + city);
        System.out.println("age = " + age);
    }

    /*
     * (8) @RequestParam - 조건부 생략 (기본타입 + Array) / 생략불가(List, Map, ..)
     * */
    // request parameter의 이름이 method parameter와 같으면
    // @RequestParam의 value 속성을 생략 가능
    // + @RequestParam 생략 가능
    // /main2/sub12?city=seoul&age=44
    @RequestMapping(value = "/main2/sub12")
    public void sub12(String city, int age) {
        System.out.println("city = " + city);
        System.out.println("age = " + age);
    }

    /*
     * (9) @RequestParam - 파라미터 필수값(required=true)
     * */
    // /main2/sub13?email=gmail&score=88.8&married=true
    // /main2/sub13?score=88.8&married=true
    // @RequestParam이 명시된 파라미터는 url에 포함하지 않으면 null로 반환
    @RequestMapping(value = "/main2/sub13")
    public void sub13(String email, double score, boolean married) {
        System.out.println("email = " + email);
        System.out.println("score = " + score);
        System.out.println("married = " + married);
    }

    /*
     * (10) @RequestParam - 파라미터 미포함(required=false)
     * */
    // /main2/sub14?email=gmail&score=88.8&married=true
    // /main2/sub14?score=88.8&married=true
    // @RequestParam이 명시된 파라미터는 url에 반드시 포함해야한다(포함하지 않으면 Error)
    // @RequestParam(required = false) 는 url에 포함하지 않으면 null로 반환 (* 기본타입이라면 Error)
    @RequestMapping(value = "/main2/sub14")
    public void sub14(@RequestParam(required = false) String email,
                      @RequestParam(required = false) Double score, Boolean married) {
        System.out.println("email = " + email);
        System.out.println("score = " + score);
        System.out.println("married = " + married);
    }

    /*
     * (11) @RequestParam - 기본값 부여 (required=false, defaultValue="")
     * */
    // 파라미터 값이 존재하지 않을 때 기본 값을 부여할 수 있다.
    @RequestMapping(value = "/main2/sub15")
    public void sub15(@RequestParam(required = false, defaultValue = "") String email,
                      @RequestParam(required = false, defaultValue = "0.0") Double score,
                      @RequestParam(required = false, defaultValue = "false") Boolean married) {
        System.out.println("email = " + email);
        System.out.println("score = " + score);
        System.out.println("married = " + married);
    }

    /*
     * (12) @RequestParam - 기본값 부여 시, required=false 생략
     * */
    // 파라미터 값이 존재하지 않을 때 기본 값을 부여할 수 있다. 기본값을 부여하면 required=false 생략 가능
    @RequestMapping(value = "/main2/sub16")
    public void sub16(@RequestParam(defaultValue = "") String email,
                      @RequestParam(defaultValue = "0.0") Double score,
                      @RequestParam(defaultValue = "false") Boolean married) {
        System.out.println("email = " + email);
        System.out.println("score = " + score);
        System.out.println("married = " + married);
    }

    // /main2/sub17?city=seoul&home=jeju&age=33
    // /main2/sub17?city=seoul&home=jeju
    // /main2/sub17?city=seoul&age=33
    // /main2/sub17?home=jeju&age=33
    // city 기본값 "", home 기본값 "", age 기본값 "0"
    @RequestMapping("/main2/sub17")
    public void sub17(@RequestParam(defaultValue = "") String city,
                      @RequestParam(defaultValue = "") String home,
                      @RequestParam(defaultValue = "0") Integer age) {
        System.out.println("city = " + city);
        System.out.println("home = " + home);
        System.out.println("age = " + age);
    }

    /*
     * (13) @RequestParam - 요청 파라미터의 여러 값 (Array, List)
     * */
    // 하나의 Request Parameter(요청 파라미터, 요청 변수)가 여러값인 경우
    // /main2/sub18?city=seoul&city=jeju&city=busan
    // /main2/sub18?city=seoul&city=jeju
    // /main2/sub18?city=seoul
    // /main2/sub18?
    @RequestMapping("/main2/sub18")
    public void method18(String[] city) {
        System.out.println("Arrays.toString(city) = " + Arrays.toString(city));
    }

    // List, Map 타입의 경우 @RequestParam 생략 불가 = Model 객체로 바인딩될 수 있는 타입이므로
    @RequestMapping("/main2/sub19")
    public void method19(@RequestParam(value = "city", defaultValue = "") ArrayList<String> city) {
        System.out.println("city = " + city);
    }

    // /main2/sub20?country=korean&score=90&score=80&score=70
    @RequestMapping("/main/sub20")
    public void method20(String country, Integer[] score) {
        System.out.println("country = " + country);
        System.out.println("score = " + Arrays.toString(score));
    }

    // /main2/sub21?city=서울&email=gmail&address=신촌&age=88&score=98&married=true
    @RequestMapping("/main2/sub21")
    public void method21(
            String city,
            String email,
            String address,
            Integer age,
            Double score,
            Boolean married) {
        System.out.println("city = " + city);
        System.out.println("email = " + email);
        System.out.println("address = " + address);
        System.out.println("age = " + age);
        System.out.println("score = " + score);
        System.out.println("married = " + married);
    }

    /*
     * (14) @RequestParam - 요청 파라미터의 여러 값 (Map, MultiValueMap)
     * */
    // /main2/sub21?city=서울&email=gmail&address=신촌&age=88&score=98&married=true
    @RequestMapping("/main2/sub22")
    public void method22(@RequestParam Map<String, Object> params) {
        for (var entry : params.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    // /main2/sub23?city=서울&email=gmail&address=신촌&age=88&score=98&score=87&score=76&married=true
    @RequestMapping("/main2/sub23")
    public void method23(@RequestParam MultiValueMap<String, Object> params) {
        for (var entry : params.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    /*
     * (15) WebRequest 요청정보
     * */
    // Request 요청정보 얻기 (method, servletPath)
    @RequestMapping("/main2/sub24")
    public void method24(WebRequest request) {
        Class<? extends WebRequest> clazz = request.getClass();
        if (request instanceof StandardServletAsyncWebRequest b) {
            Object c = b.getNativeRequest();
            System.out.println("c.getClass() = " + c.getClass());
            //c.getClass() = class org.apache.catalina.connector.RequestFacade
            if (c instanceof RequestFacade d) {
                String method = d.getMethod();
                String servletPath = d.getServletPath();
                System.out.println("method = " + method);
                //method = GET
                System.out.println("servletPath = " + servletPath);
                //servletPath = /main2/sub24
            }
        }
        System.out.println("clazz = " + clazz);
        //clazz = class org.springframework.web.context.request.async.StandardServletAsyncWebRequest
    }
}
