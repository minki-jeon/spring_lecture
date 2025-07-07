package com.example.spring.controller;

import com.example.spring.dto.MyBean291;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@ResponseBody
@RequestMapping("/api/main30")
public class Controller30 {
    //    @RequestMapping(method = RequestMethod.PUT, path = "sub1")
    @PutMapping("sub1")
    public String sub1() {
        System.out.println("Controller30.sub1");
        return null;
    }

    //    @RequestMapping(method = RequestMethod.DELETE, path = "sub2")
    @DeleteMapping("sub2")
    public String sub2() {
        System.out.println("Controller30.sub2");
        return null;
    }

    //    @RequestMapping(method=RequestMethod.PUT, path="sub3")
    @PutMapping("sub3")
    public String sub3() {
        System.out.println("Controller30.sub3");
        return null;
    }

    @DeleteMapping("sub4")
    public String sub4() {
        System.out.println("Controller30.sub4");
        return null;
    }

    @PutMapping("sub5")
    public String sub(@RequestBody MyBean291 dto) {
        System.out.println(dto);
        return null;
    }

    @DeleteMapping("sub6")
    public String sub6(String name, Integer id) {
        System.out.println("name = " + name);
        System.out.println("id = " + id);

        return null;
    }

    @PostMapping("sub7")
    public String sub7(String name, Integer age, MultipartFile myFile) {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("myFile = " + myFile);
        System.out.println("myFile = " + myFile.getOriginalFilename());
        System.out.println("myFile = " + myFile.getSize());

        return null;
    }
}
