package com.example.spring.service;

import com.example.spring.dto.Entity36Dto;
import com.example.spring.dto.Entity39Dto;
import com.example.spring.dto.OrderInfo;
import com.example.spring.dto.ProductInfo;
import com.example.spring.entity.Entity34;
import com.example.spring.entity.Entity35;
import com.example.spring.entity.Entity36;
import com.example.spring.entity.Entity39;
import com.example.spring.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class Service8 {
    private final Entity34Repository entity34Repository;
    private final Entity35Repository entity35Repository;
    private final Entity36Repository entity36Repository;
    private final Entity39Repository entity39Repository;
    private final Entity41Repository entity41Repository;


    public void action1() {
        // 학생 정보 입력
        Entity34 s1 = new Entity34();
        Entity34 s2 = new Entity34();
        Entity34 s3 = new Entity34();
        s1.setName("lee");
        s2.setName("wang");
        s3.setName("zhang");
        entity34Repository.save(s1);
        entity34Repository.save(s2);
        entity34Repository.save(s3);

        // 강의 정보 입력
        Entity35 l1 = new Entity35();
        Entity35 l2 = new Entity35();
        Entity35 l3 = new Entity35();
        l1.setLectureTitle("java");
        l2.setLectureTitle("python");
        l3.setLectureTitle("react");
        entity35Repository.save(l1);
        entity35Repository.save(l2);
        entity35Repository.save(l3);

        // 수강 정보 입력
        Entity36 i1 = new Entity36();
        Entity36 i2 = new Entity36();
        Entity36 i3 = new Entity36();
        Entity36 i4 = new Entity36();
        Entity36 i5 = new Entity36();
        Entity36 i6 = new Entity36();

        i1.setRegisteredAt(LocalDate.now());
        i2.setRegisteredAt(LocalDate.now());
        i3.setRegisteredAt(LocalDate.now());
        i4.setRegisteredAt(LocalDate.now());
        i5.setRegisteredAt(LocalDate.now());
        i6.setRegisteredAt(LocalDate.now());

        // 학생1->강의1,2
        i1.setStudent(s1);
        i2.setStudent(s1);
        i1.setLecture(l1);
        i2.setLecture(l2);
        // 학생2->강의2,3
        i3.setStudent(s2);
        i4.setStudent(s2);
        i3.setLecture(l2);
        i4.setLecture(l3);
        // 학생3->강의1,3
        i5.setStudent(s3);
        i6.setStudent(s3);
        i5.setLecture(l1);
        i6.setLecture(l3);

        entity36Repository.saveAll(List.of(i1, i2, i3, i4, i5, i6));


    }

    public void action2() {
        // 학생 record 2개
        Entity34 s1 = new Entity34();
        Entity34 s2 = new Entity34();
        s1.setName("kang");
        s2.setName("Jang");
        entity34Repository.save(s1);
        entity34Repository.save(s2);
        // 강의 record 2개
        Entity35 l1 = new Entity35();
        Entity35 l2 = new Entity35();
        l1.setLectureTitle("php");
        l2.setLectureTitle("javascript");
        entity35Repository.save(l1);
        entity35Repository.save(l2);
        // 수강 record 2개 (학생1=강의1)
        Entity36 i1 = new Entity36();
        Entity36 i2 = new Entity36();
        i1.setRegisteredAt(LocalDate.now());
        i2.setRegisteredAt(LocalDate.now());
        //학생1
        i1.setStudent(s1);
        i2.setStudent(s2);
        i1.setLecture(l1);
        i2.setLecture(l2);
        entity36Repository.saveAll(List.of(i1, i2));
    }

    public void action3() {
        // 4번학생 수강 삭제
        entity36Repository.deleteByStudentId(4);
    }

    public void action4() {
        // 5번 학생 삭제
        // - 참조키로 사용되어지고 있는 데이터 삭제
        entity34Repository.deleteById(5);   // 제약사항 위반

    }
    public void action5() {
        // 5번 학생의 수강정보를 먼저 삭제 후, 5번 학생 삭제
        entity36Repository.deleteByStudentId(5);
        entity34Repository.deleteById(5);
    }

    public void action6() {
        // 3번 강의 삭제(참조키로 사용되어지고 있는 수강 정보를 먼저 삭제)
        entity36Repository.deleteByLectureId(3);
        entity35Repository.deleteById(3);
    }

    public void action7() {
        Entity36 l1 = entity36Repository.findById(1).get();
        System.out.println(l1.getRegisteredAt());   // my_table36 조회

        Entity34 s1 = l1.getStudent();              // my_table34를 아직 조회하지 않는다.
        // LAZY일 경우 이 때 SELECT my_table34 쿼리 실행
        String name = s1.getName();
        System.out.println("name = " + name);

    }

    public Entity36 action8() {
        Entity36 l1 = entity36Repository.findById(1).get();

        return l1;

    }

    public Entity36Dto action9() {
        Entity36 l1 = entity36Repository.findById(1).get();
        // Entity를 리턴하지 않도록 한다.
        // -> DTO로 값을 옮겨담아 리턴하도록 한다.
        Entity36Dto d1 = new Entity36Dto();
        d1.setRegisteredAt(l1.getRegisteredAt());
        d1.setStudentName(l1.getStudent().getName());

        return d1;

    }


    public void action10() {
        // t39(product), t40(category)
        // 상품번호, 상품명, 가격, 카테고리명
        List<Entity39> list = entity39Repository.findAll();

        List<Entity39Dto> result = new ArrayList<>();
        for (Entity39 entity39 : list) {
            Entity39Dto d = new Entity39Dto();
            d.setId(entity39.getId());
            d.setName(entity39.getName());
            d.setPrice(entity39.getPrice());
            d.setCategoryName(entity39.getCategory().getName());
            result.add(d);
        }

    }

    public List<ProductInfo> action11() {
        // t39(product), t40(category)
        // 상품번호, 상품명, 가격, 카테고리명
        /*
        SELECT p.id, p.name product_name, p.price, c.name category_name
        FROM t39 p JOIN t40 c p.category_id = c.id
         */
        List<ProductInfo> list = entity39Repository.query1();

        return list;
    }

    public List<OrderInfo> action12() {
        List<OrderInfo> result = entity41Repository.query1();

        return result;
    }
}
