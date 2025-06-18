package com.example.spring.service;

import com.example.spring.entity.Entity27;
import com.example.spring.entity.Entity28;
import com.example.spring.repository.Entity27Repository;
import com.example.spring.repository.Entity28Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class Service7 {

    private final Entity27Repository entity27Repository;
    private final Entity28Repository entity28Repository;

    public void action1() {
        Entity27 c1 = new Entity27();
        Entity27 c2 = new Entity27();
        Entity27 c3 = new Entity27();

        c1.setCategoryName("음료수");
        c1.setInfo("설탕물");

        c2.setCategoryName("전자제품");
        c2.setInfo("전기를 사용하는 물건");

        c3.setCategoryName("청소용품");
        c3.setInfo("청소할 때 필요해");

        entity27Repository.save(c1);
        entity27Repository.save(c2);
        entity27Repository.save(c3);

    }

    public void action2() {
        Entity28 p1 = new Entity28();
        Entity28 p2 = new Entity28();
        Entity28 p3 = new Entity28();
        Entity28 p4 = new Entity28();
        Entity28 p5 = new Entity28();
        Entity28 p6 = new Entity28();

        p1.setPrice(500);
        p2.setPrice(300);
        p3.setPrice(200);
        p4.setPrice(100);
        p5.setPrice(50);
        p6.setPrice(10);

        p1.setProductName("청소기");
        p2.setProductName("컴퓨터");
        p3.setProductName("콜라");
        p4.setProductName("사이다");
        p5.setProductName("물티슈");
        p6.setProductName("모니터");

        p1.setUnit("1대");
        p2.setUnit("1대");
        p3.setUnit("1캔");
        p4.setUnit("1캔");
        p5.setUnit("1장");
        p6.setUnit("1대");

        Entity27 c1 = entity27Repository.findById(1).get();
        Entity27 c2 = entity27Repository.findById(2).get();
        Entity27 c3 = entity27Repository.findById(3).get();

        p1.setCategory(c3);
        p2.setCategory(c2);
        p3.setCategory(c1);
        p4.setCategory(c1);
        p5.setCategory(c3);
        p6.setCategory(c2);

        entity28Repository.save(p1);
        entity28Repository.save(p2);
        entity28Repository.save(p3);
        entity28Repository.save(p4);
        entity28Repository.save(p5);
        entity28Repository.save(p6);

    }
}
