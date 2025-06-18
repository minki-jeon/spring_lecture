package com.example.spring.service;

import com.example.spring.entity.Entity21;
import com.example.spring.repository.Entity21Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class Service6 {

    private final Entity21Repository entity21Repository;

    public void action1(String name, String address) {
        Entity21 data = new Entity21();
        data.setName(name);
        data.setAddress(address);
//        data.setInsertedAt(LocalDateTime.now());      // Entity에 insertable = false 로 기능 off
        entity21Repository.save(data);

    }
}
