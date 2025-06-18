package com.example.spring.service;

import com.example.spring.entity.Entity16;
import com.example.spring.repository.Entity16Repository;
import com.example.spring.repository.Entity19Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Service5 {

    private final Entity16Repository entity16Repository;

    // Paging
    public void action1(Integer page) {
        // repository
        Page<Entity16> pageContent = entity16Repository
                .findAll(PageRequest.of(page - 1, 10, Sort.by("id").descending()));
        List<Entity16> content = pageContent.getContent();
        content.forEach(System.out::println);

    }

    // Searching
    public void action2(String country) {
        List<Entity16> list = entity16Repository
                .findByCountry(country);
        list.forEach(System.out::println);

    }


    public void action3(String country, Integer page) {
        Page<Entity16> pageContent = entity16Repository
                .findByCountry(country, PageRequest.of(page - 1, 10, Sort.by("id").descending()));
        List<Entity16> content = pageContent.getContent();
        content.forEach(System.out::println);

    }

    public void action4(String keyword, Integer page) {
    //* SELECT * FROM customer WHERE customer_name LIKE '%ed%' OR contact_name LIKE '%ed%'
//        List<Entity16> pageContent = entity16Repository
//                .findByCustomerNameContainingOrContactNameContaining(keyword, keyword);
//        pageContent.forEach(System.out::println);
        Page<Entity16> pageContent = entity16Repository
                .findByCustomerNameContainingOrContactNameContaining(keyword, keyword, PageRequest.of(page - 1, 10, Sort.by("id").descending()));
        List<Entity16> content = pageContent.getContent();
        content.forEach(System.out::println);

    }
}
