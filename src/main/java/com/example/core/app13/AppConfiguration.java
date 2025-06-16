package com.example.core.app13;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Service1 클래스에 어노테이션(@Component)으로 직접 Bean 생성하지 않고,
// 별도로 Bean 생성하는 방법 (@Configuration + @Bean)
@Configuration
class AppConfiguration {

    @Bean
//    public Service1 makeBean() {
    public Service1 myService() {
        // 해당 메소드명이 SpringBean의 이름으로 결정된다.
        return new Service1();
    }



    @Bean
    public Service2 myService2() {
        return new Service2();
    }
}