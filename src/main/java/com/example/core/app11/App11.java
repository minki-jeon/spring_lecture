package com.example.core.app11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App11 {
    public static void main(String[] args) {
        var context = SpringApplication.run(App11.class, args);
        Bean1 bean = context.getBean(Bean1.class);
        bean.some();
    }
}
