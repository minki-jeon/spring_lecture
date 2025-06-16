package com.example.core.app5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Controller1 {
    // Field DI
    @Autowired
    Service1 service;

    public void go() {
        service.action();
    }
}
