package com.example.spring.service;

import com.example.spring.entity.Entity27;
import com.example.spring.entity.Entity28;
import com.example.spring.entity.Entity29;
import com.example.spring.entity.Entity30;
import com.example.spring.repository.Entity27Repository;
import com.example.spring.repository.Entity28Repository;
import com.example.spring.repository.Entity29Repository;
import com.example.spring.repository.Entity30Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional
public class Service7 {

    private final Entity27Repository entity27Repository;
    private final Entity28Repository entity28Repository;

    private final Entity29Repository entity29Repository;
    private final Entity30Repository entity30Repository;

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

    public void action3(Integer id) {
        Entity27 entity27 = entity27Repository.findById(id).get();
        System.out.println("entity27 = " + entity27);
    }

    public void action4(Integer id) {
        Entity28 entity28 = entity28Repository.findById(id).get();
        // 참조키에 대한 상위 테이블 정보도 같이 조회
        System.out.println("entity28 = " + entity28);
    }

    public void action5() {
        Entity29 e1 = new Entity29();
        Entity29 e2 = new Entity29();
        Entity29 e3 = new Entity29();

        e1.setBirthDate(LocalDate.parse("2011-01-01"));
        e1.setFirstName("kim");
        e1.setLastName("JE");

        e2.setBirthDate(LocalDate.parse("2021-02-02"));
        e2.setFirstName("Lee");
        e2.setLastName("JM");

        e3.setBirthDate(LocalDate.parse("2031-03-03"));
        e3.setFirstName("Park");
        e3.setLastName("JE");

        entity29Repository.save(e1);
        entity29Repository.save(e2);
        entity29Repository.save(e3);

    }

    public void action6() {
        Entity30 o1 = new Entity30();
        Entity30 o2 = new Entity30();
        Entity30 o3 = new Entity30();
        Entity30 o4 = new Entity30();
        Entity30 o5 = new Entity30();
        Entity30 o6 = new Entity30();

        o1.setOrderDate(LocalDate.parse("2011-11-11"));
        o2.setOrderDate(LocalDate.parse("2012-12-12"));
        o3.setOrderDate(LocalDate.parse("2013-03-31"));
        o4.setOrderDate(LocalDate.parse("2014-04-04"));
        o5.setOrderDate(LocalDate.parse("2015-05-05"));
        o6.setOrderDate(LocalDate.parse("2016-06-06"));

        o1.setInfo("오더1");
        o2.setInfo("오더2");
        o3.setInfo("오더3");
        o4.setInfo("오더4");
        o5.setInfo("오더5");
        o6.setInfo("오더6");

        Entity29 e1 = entity29Repository.findById(1).get();
        Entity29 e2 = entity29Repository.findById(2).get();
        Entity29 e3 = entity29Repository.findById(3).get();

        o1.setEmployee(e3);
        o2.setEmployee(e2);
        o3.setEmployee(e1);
        o4.setEmployee(e1);
        o5.setEmployee(e3);
        o6.setEmployee(e2);

        entity30Repository.save(o1);
        entity30Repository.save(o2);
        entity30Repository.save(o3);
        entity30Repository.save(o4);
        entity30Repository.save(o5);
        entity30Repository.save(o6);
    }


    public void action7(Integer id) {
        Entity29 entity29 = entity29Repository.findById(id).get();
        System.out.println("entity29 = " + entity29);
    }


    public void action8(Integer id) {
        Entity30 entity30 = entity30Repository.findById(id).get();
        System.out.println("entity30 = " + entity30);
    }
}
