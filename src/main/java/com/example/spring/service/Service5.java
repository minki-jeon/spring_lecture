package com.example.spring.service;

import com.example.spring.entity.Entity16;
import com.example.spring.entity.Entity20;
import com.example.spring.repository.Entity16Repository;
import com.example.spring.repository.Entity18Repository;
import com.example.spring.repository.Entity20Repository;

//* 동일한 Transactional library지만 통일성을 위해 springframework import
//import jakarta.transaction.Transactional;
import org.springframework.transaction.annotation.Transactional;

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
    private final Entity20Repository entity20Repository;
    private final Entity18Repository entity18Repository;

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

    // Jpa에서 기본 제공하는 메소드는 내부에서 Transactional 적용되어 있다.
    public void action5(Integer id) {
        entity16Repository.deleteById(id);
    }
    // 기본 제공하는 메소드가 아닌 커스텀 Query Method는 직접 Transactional 적용해야한다.
    @Transactional
    public void action6(String country) {
        entity16Repository.deleteByCountry(country);
    }

    public void action7() {
        Entity20 a = entity20Repository.findById("a").get();
        Entity20 b = entity20Repository.findById("b").get();

        a.setMoney(a.getMoney() - 500);
        entity20Repository.save(a);

        if (true) {
            // 강제 exception
            throw new RuntimeException("네트워크 오류");
        }

        b.setMoney(b.getMoney() + 500);
        entity20Repository.save(b);
    }

    @Transactional
    public void action8() {
        // 보통 service에서 하나의 메소드가 하나의 Transaction을 의미
        // -> @Transactional 어노테이션을 service의 모든 메소드에 붙여야한다.

        Entity20 a = entity20Repository.findById("a").get();
        Entity20 b = entity20Repository.findById("b").get();

        a.setMoney(a.getMoney() - 500);
        entity20Repository.save(a);

        if (true) {
            // 강제 exception
            throw new RuntimeException("네트워크 오류");
            // Transactional에 의해 Rollback 동작
        }

        b.setMoney(b.getMoney() + 500);
        entity20Repository.save(b);
    }

    @Transactional
    public void action9(String country) {
        entity18Repository.deleteByCountry(country);

    }
    @Transactional
    public void action10(String country) {
        // select 실행 후 하나씩 삭제 : 성능 저하 이슈
//        entity18Repository.deleteByCountry(country);

        // -> jpql 또는 sql로 직접 작성해서 삭제
        entity16Repository.bulkDeleteByCountry(country);

    }

    @Transactional
    public void action11(String country) {
        entity18Repository.deleteAllByCountry(country);
    }

    @Transactional
    public void action12(String country) {
        // update, delete, insert

        // rollback 동작
        // throw new RuntimeException();

        // update, delete, insert

    }
    @Transactional
    public void action13(String country) {
        // update, delete, insert

        // rollback 동작하지 않음 (checked exception)
        // throw new Exception();

        // update, delete, insert

    }
    @Transactional
    public void action14(String country) {
        // update, delete, insert

        // rollback 동작하지 않음
        // throw new Exception();
        if (true) {
            try {
                throw new Exception();
            } catch (Exception e) {
                // rollback
                throw new RuntimeException(e);
            }
        }

        try {
            throw new Exception();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // update, delete, insert

    }



}
