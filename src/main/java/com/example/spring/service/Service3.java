package com.example.spring.service;

import com.example.spring.entity.Entity16;
import com.example.spring.entity.Entity17;
import com.example.spring.repository.Entity16Repository;
import com.example.spring.repository.Entity17Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    }
}
