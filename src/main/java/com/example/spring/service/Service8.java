package com.example.spring.service;

import com.example.spring.entity.Entity34;
import com.example.spring.entity.Entity35;
import com.example.spring.entity.Entity36;
import com.example.spring.repository.Entity34Repository;
import com.example.spring.repository.Entity35Repository;
import com.example.spring.repository.Entity36Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class Service8 {
    private final Entity34Repository entity34Repository;
    private final Entity35Repository entity35Repository;
    private final Entity36Repository entity36Repository;


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
}
