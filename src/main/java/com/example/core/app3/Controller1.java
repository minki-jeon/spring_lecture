package com.example.core.app3;

import org.springframework.stereotype.Component;

//@Component("bean1")
@Component
// 이름을 제시하지 않으면 클래스명(bean)을 lowerCamelCase로 바꾼 이름을 짓는다.
public class Controller1 {  // ==> "controller1"
    public void method1() {
        System.out.println("Controller1.method1");
    }
}
