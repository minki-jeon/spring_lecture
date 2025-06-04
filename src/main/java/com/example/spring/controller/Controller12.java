package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("main12")
public class Controller12 {

    @RequestMapping("sub1")
    public String sub1(Model model) {
        model.addAttribute("address", "seoul");
        return "main12/sub1";
    }

    /*
         2025-06-04 (수) 오전 9:22
        (1) redirection : 다른 곳으로 요청하라는 응답
     */
    @GetMapping("sub2")
    public String sub2(Model model, RedirectAttributes rttr) {

        model.addAttribute("country", "korea");
        /*
             2025-06-04 (수) 오전 9:36
             RedirectAttributes.addFlashAttribute(Name, Value)
         */
        rttr.addFlashAttribute("city", "seoul");

        return "redirect:/main12/sub3";
    }

    @GetMapping("sub3")
    public String sub3(Model model) {
        System.out.println("Controller12.sub3");

        model.addAttribute("email", "yahoo");

        return "/main12/sub3";
    }

    /*
         2025-06-04 (수) 오전 9:37
        http://localhost:8080/main12/sub4
     */
    @GetMapping("sub4")
    public String sub4(Model model, RedirectAttributes rttr) {
        rttr.addFlashAttribute("name", "donald");
        return "redirect:/main12/sub5";
    }

    @GetMapping("sub5")
    public String sub5(Model model) {

        return "/main12/sub5";
    }

    /*
         2025-06-04 (수) 오전 9:45
         (2) RedirectAttributes.addAttribute
     */
    @GetMapping("sub6")
    public String sub6(RedirectAttributes rttr) {
        // 다음 요청 Model에 옮겨 담음
        rttr.addFlashAttribute("nickName", "trump");

        // query string에 추가
        rttr.addAttribute("address", "jeju");

        return "redirect:/main12/sub7";
    }
    @GetMapping("sub7")
    public String sub7(Model model) {
        return "/main12/sub7";
    }

    /*
         2025-06-04 (수) 오전 9:52
     */
    @GetMapping("sub8")
    public String sub8(RedirectAttributes rttr) {
        // Model
        rttr.addFlashAttribute("item", "car");

        // QueryString
        rttr.addAttribute("company", "tesla");

        return "redirect:/main12/sub9";
    }
    @GetMapping("sub9")
    public String sub9(Model model) {
        return "/main12/sub9";
    }
}
