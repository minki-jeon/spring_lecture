package com.example.core.app2;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
// main 메소드가 있는 패키지와 그 하위 패키지를 모두 Scan(탐색)하여 특정 어노테이션(Component)이 붙은 클래스의 객체를 생성해서 보관
public class App2 {
    public static void main(String[] args) {
        // 서비스 객체 만들고
        // 컨트롤러 객체 만들고
        // 서비스를 컨트롤러 객체에 주입(injection)

        //* 초기파일 \Spring\Application.java 참고
        var context = SpringApplication.run(App2.class, args);
        // getBean() : 스프링이 만든 객체(Spring Bean) 얻기
        Controller1 bean = context.getBean(Controller1.class);
        bean.method1();

        Object c1 = context.getBean("c1");

        System.out.println(bean == c1);

    }

}

@Component("c1")
class Controller1 {
    public void method1() {
        System.out.println("요청 처리 메소드");
    }
}
