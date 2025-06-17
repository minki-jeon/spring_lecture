package com.example.spring.service;

import com.example.spring.entity.Entity16;
import com.example.spring.entity.Entity17;
import com.example.spring.repository.Entity16Repository;
import com.example.spring.repository.Entity17Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Service3 {

    private final Entity16Repository entity16Repository;
    private final Entity17Repository entity17Repository;

    public void action1() {
        // findById(pk) : pk에 해당하는 하나의 레코드 조회
        Entity16 entity16 = entity16Repository.findById(1).get();
        System.out.println(entity16);

    }

    public void action2() {
        // findAll() : 모든 레코드 조회
        List<Entity16> list = entity16Repository.findAll();
        System.out.println(list.size());

    }

    public void action3() {
        List<Entity17> list = entity17Repository.findAll();
        System.out.println(list.size());
        
        for (Entity17 entity17 : list) {
            System.out.println(entity17);
        }
    }

    public void action4(String country) {
        /*
        SELECT *
        FROM customer
        WHERE country = 'usa';
         */
        List<Entity16> data = entity16Repository.query1(country);
        System.out.println("data.size() = " + data.size());
        for (Entity16 entity16 : data) {
            System.out.println(entity16);
        }
    }

    public void action5(String city) {
        List<Entity16> data = entity16Repository.query2(city);
        System.out.println("data.size() = " + data.size());
        for (Entity16 entity16 : data) {
            System.out.println(entity16);
        }

    }

    public void action6(String city1, String city2) {
        List<Entity16> data = entity16Repository.query3(city1, city2);
        System.out.println("data.size() = " + data.size());
        for (Entity16 entity16 : data) {
            System.out.println(entity16);
        }

    }

    public void action7(LocalDate start, LocalDate end) {
        List<Entity17> data = entity17Repository.query1(start, end);
        System.out.println("data.size() = " + data.size());
        for (Entity17 entity17 : data) {
            System.out.println(entity17);
        }
    }
}
