package com.example.spring.service;

import com.example.spring.entity.*;
import com.example.spring.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Service2 {

    private final Entity1Repository entity1Repository;
    private final Entity2Repository entity2Repository;
    private final Entity3Repository entity3Repository;
    private final Entity4Repository entity4Repository;
    private final Entity5Repository entity5Repository;
    private final Entity10Repository entity10Repository;
    private final Entity11Repository entity11Repository;
    private final Entity12Repository entity12Repository;
    private final Entity13Repository entity13Repository;
    private final Entity14Repository entity14Repository;
    private final Entity15Repository entity15Repository;

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

    public void process5() {
        Entity4 res = entity4Repository.findById(1).get();
        System.out.println(res);
    }

    public void process6() {
        Entity5 entity5 = entity5Repository.findById(1).get();
        System.out.println(entity5);
    }

    // JPA SELETE
    public void process7() {
        // findById : 기본키(id)로 하나의 recode(row)를 조회
//        Entity10 entity10 = entity10Repository.findById(1).get();
        Optional<Entity10> data = entity10Repository.findById(1);
        System.out.println(data.isPresent());       // (데이터가 존재하는지 확인)
        System.out.println(data.isEmpty());         // (데이터가 존재하지 않는지 확인)
    }

    // entity11Repository.findById() / process8() / Controller - request handler method
    public void process8() {
        Optional<Entity11> data = entity11Repository.findById(1);
        System.out.println(data.isPresent());
        System.out.println(data.isEmpty());
    }

    public void process9() {
        Optional<Entity12> data = entity12Repository.findById(1);
        System.out.println(data.isPresent());
        System.out.println(data.isEmpty());
    }

    public void process10() {
        Optional<Entity13> byId = entity13Repository.findById(1);
        System.out.println(byId.isPresent());
        System.out.println(byId.isEmpty());
    }

    public Entity14 process11(Integer id) {
        // SELECT:
        // findById(key) : key에 해당하는 record를 저장한 Entity 객체를 리턴(Optional)
        Optional<Entity14> data = entity14Repository.findById(id);

        if (data.isPresent()) {
            return data.get();
        }

        return null;
    }

    // JPA INSERT
    public void process12(String name, Double score, String city) {
        // INSERT
        // save() : 해당 entity를 새 recod로 입력
        //          해당 entity에 매핑되는 recode를 업데이트
        Entity14 data = new Entity14();
//        data.setName("son");
//        data.setScore(22.2);
//        data.setCity("london");
        data.setName(name);
        data.setScore(score);
        data.setCity(city);

        entity14Repository.save(data);
    }

    public void process13(String address, Integer price, LocalDateTime inserted) {
        Entity15 data = new Entity15();
        data.setAddress(address);
        data.setPrice(price);
        data.setInsertedAt(inserted);
        entity15Repository.save(data);
    }

    // JPA UPDATE
    public void process14(Integer id, Double score) {
//        Entity14 data = new Entity14();   // SELETE 조회없이 존재하는 pk로 Data를 Set할 경우 set하지 않는 컬럼의 Data는 Null로 UPDATE 된다.
        //1. 조회하고
//        Entity14 data = entity14Repository.findById(1).get();
        Entity14 data = entity14Repository.findById(id).get();
        //2. 값 변경
//        data.setName("강");      // update
        data.setScore(score);
        //3. save
        entity14Repository.save(data);
    }

    public void process15(Integer id, String address) {
        Entity15 data = entity15Repository.findById(id).get();
        data.setAddress(address);
        entity15Repository.save(data);
    }

    // JPA DELETE
    public void process16(Integer id) {
        entity14Repository.deleteById(id);
    }

    public void process17(Integer id) {
        entity15Repository.deleteById(id);
    }
}
