package com.example.spring.service;

import com.example.spring.entity.Entity16;
import com.example.spring.entity.Entity19;
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
public class Sercice4 {
    private final Entity16Repository entity16Repository;
    private final Entity19Repository entity19Repository;

    public void action1() {
        System.out.println("page 1 ============================================");
        // Paging
        Page<Entity16> list = entity16Repository.findAll(PageRequest.of(1 - 1, 10));  // page 1
        List<Entity16> data = list.getContent();

        for (Entity16 entity16 : data) {
            System.out.println(entity16);
        }

        System.out.println("page 2 ============================================");
        List<Entity16> list2 = entity16Repository.findAll(PageRequest.of(2 - 1, 10)).getContent();
        for (Entity16 entity16 : list2) {
            System.out.println(entity16);
        }

    }

    public void action2() {
        // 상품 정보 페이지당 7개씩 페이지1
        List<Entity19> list1 = entity19Repository.findAll(PageRequest.of(1 - 1, 7)).getContent();
        for (Entity19 entity19 : list1) {
            System.out.println(entity19);
        }

        // 상품 정보 페이지당 7개씩 페이지2
        entity19Repository.findAll(PageRequest.of(2 - 1, 7)).getContent().forEach(System.out::println);

    }

    public void action3() {
        // 페이징 and 정렬
        System.out.println("page 1 =============================================");
        List<Entity19> list1 = entity19Repository
                .findAll(PageRequest.of(1 - 1, 7, Sort.by("productName")))
                .getContent();
        for (Entity19 entity19 : list1) {
            System.out.println(entity19);
        }

    }

    public void action4() {
        // 고객Contact 기준으로 1페이지 출력 (페이지당 10개)
        entity16Repository
                .findAll(PageRequest.of(1 - 1, 10, Sort.by("contactName").descending()))
                .getContent()
                .forEach(System.out::println);

    }

    public void action5() {
        // 가격 역순 10개씩 1페이지 상품 조회
        entity19Repository
                .findAll(PageRequest.of(1 - 1, 10, Sort.by("price").descending()))
                .getContent()
                .forEach(System.out::println);
    }


    public void action6(Integer page) {


        System.out.println("=== page " + page + " ============================================");
        Page<Entity16> page1 = entity16Repository
                .findAll(PageRequest.of(page - 1, 10, Sort.by("id").descending()));
        List<Entity16> content1 = page1.getContent();
        int totalPages = page1.getTotalPages();         // 10
        long totalElements = page1.getTotalElements();  // 91

        System.out.println("totalPages = " + totalPages);
        System.out.println("totalElements = " + totalElements);

//        content1.forEach(System.out::println);
        content1.forEach(Entity16 -> System.out.println(Entity16));

    }


    public void action7(Integer page) {
        System.out.println("=== page " + page + " ===========================================");

        Page<Entity19> page1 = entity19Repository.findAll(PageRequest.of(page - 1, 10, Sort.by("price")));
        List<Entity19> content1 = page1.getContent();

        int totalPages = page1.getTotalPages();
        long totalElements = page1.getTotalElements();

        content1.forEach(Entity19 -> System.out.println(Entity19));

//        boolean last = page1.isLast();
//        System.out.println("다음 페이지 유무 : " + ! last);
        boolean next = page1.hasNext();
        System.out.println("다음 페이지 유무 : " + next);

        System.out.println("totalPages = " + totalPages);
        System.out.println("totalElements = " + totalElements);




    }
}
