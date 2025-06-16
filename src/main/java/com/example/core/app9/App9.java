package com.example.core.app9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App9 {
    public static void main(String[] args) {
        var context = SpringApplication.run(App9.class, args);
        Comp2 bean = context.getBean(Comp2.class);
        bean.action1();
    }
}
