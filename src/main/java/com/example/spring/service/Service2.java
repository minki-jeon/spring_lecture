package com.example.spring.service;

import com.example.spring.entity.Entity1;
import com.example.spring.entity.Entity2;
import com.example.spring.entity.Entity3;
import com.example.spring.repository.Entity1Repository;
import com.example.spring.repository.Entity2Repository;
import com.example.spring.repository.Entity3Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Service2 {

    private final Entity1Repository entity1Repository;
    private final Entity2Repository entity2Repository;
    private final Entity3Repository entity3Repository;

    public void process1() {
        System.out.println("실제 업무 로직 (Business Logic, CRUD) 영역");
    }

    public void process2() {
        // business logic

        // spring data jpa 를 사용해서 crud
        Entity1 res = entity1Repository.findById(1).get();
        System.out.println(res.getId());
        System.out.println(res.getName());
        System.out.println(res.getAddress());
        System.out.println(res.getCity());

    }

    public void process3() {
        Entity2 data = entity2Repository.findById(2).get();
        System.out.println(data);
    }

    /* JPA 사용
     * 1. Entity
     *      : Table과 1대1 매칭되는 클래스
     *      : 이 클래스로 만든 각 객체는 table의 각 행과 매칭된다.
     *      : @Entity, @Table - 클래스와 테이블 매핑
     *      : @Column - 클래스 필드와 테이블 컬럼과 매핑
     *      : @Id - 클래스 필드와 테이블의 PK 매핑
     *
     * 2. Repository
     *
     */



    public void process4() {
        Entity3 data = entity3Repository.findById(1).get();
        System.out.println(data);
    }

}
