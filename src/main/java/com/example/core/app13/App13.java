package com.example.core.app13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App13 {
    public static void main(String[] args) {
        var context = SpringApplication.run(App13.class, args);
        Controller1 bean = context.getBean(Controller1.class);

        //
        bean.get();


        // Configuration에서의 Spring Bean 가져오기
        Object bean1 = context.getBean("myService");
        Service1 service1 = bean.getService1();
        System.out.println(bean1 == service1);              // 참조값 동일 (ClassBean, 같은 Bean 객체)

    }
}
