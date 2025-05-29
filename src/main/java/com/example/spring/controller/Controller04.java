package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("main4")
public class Controller04 {
    @RequestMapping("sub1")
    @ResponseBody
    public String sub1() {
        //  - Server
        //    - Controller
        // 1. 요청 분석/가공
        // 2. 요청 처리(business logic)
        //    - View
        // 3. 결과 응답 (HTML)

        String htmlCode = """
                <!DOCTYPE html>
                <html>
                <body>
                    <h1>서버가 응답한 html 코드 </h1>
                    <p> 이렇게 html을 작성하는 것은 매우 불편하다. </p>
                </body>
                </html>
                """;
        return htmlCode;
    }

    // /main4/sub2?keyword=서울
    @RequestMapping("sub2")
    @ResponseBody
    public String sub2(String keyword) {
        String weather = switch (keyword) {
            case "서울" -> "날씨 맑음";
            case "울릉도" -> "바람 많이 붐";
            default -> "알 수 없음";
        };

        String htmlCode = """
                <!DOCTYPE html>
                <html>
                <body>
                    <h1>검색한 지역의 날씨</h1>
                    <h3>""" + weather + """
                    </h3>
                </body>
                </html>
                """;

        return htmlCode;
    }

    /*
     * (1) Thymeleaf : 결과 응답 (html 코드)을 view 페이지를 통해 forward하기 위한 라이브러리
     */
    @RequestMapping("sub3")
    public String sub3() {

        // 3. html 코드 응답
        // return "main4/sub3"; -> thymeleaf html 파일 위치(경로)
        // = src/main/resources/templates/main4/sub3.html
        // : view로 forward하다
        return "main4/sub3";
    }

    // src/main/resources/templates/main4/sub4.html
    @RequestMapping("sub4")
    public String sub4() {

        return "main4/sub4";
    }

    /*
     * (2) Model : 요청 처리의 결과를 받는다(저장)
     */
    @RequestMapping("sub5")
    public String sub5(Model model) {
        // 1. 요청 분석/가공
        // 2. 요청 처리(business logic)
        // 3. 결과 Attribute를 model에 담기
        model.addAttribute("name1", "결과 값1");
        model.addAttribute("name2", "결과 값2");
        // 4. view로 forwarding
        return "main4/sub5";
    }

    @RequestMapping("sub6")
    public String sub6(Model model) {
        // model attribute : model에 넣은 값(객체)
        model.addAttribute("name", "donald");
        model.addAttribute("address", "la");
        model.addAttribute("email", "gmail");
        return "main4/sub6";
    }

    @RequestMapping("sub7")
    public String sub7(Model model) {
        model.addAttribute("age", "55");
        model.addAttribute("score", "97.54");
        model.addAttribute("school", "서울대");
        model.addAttribute("city", "신림동");
        return "main4/sub7";
    }

    @RequestMapping("sub8")
    public String sub8(Model model) {
        model.addAttribute("number", "1234567");
        return "main4/sub8";
    }
}
