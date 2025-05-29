package com.example.spring.dto;

import lombok.*;

// 주로 사용되는 Lombok Annotations
@Getter                 // getter()
@Setter                 // setter()
@ToString               // toString()
@EqualsAndHashCode      // equals() + hashCode()
//@NoArgsConstructor      // 파라미터 없는 생성자 (기본생성자)
@AllArgsConstructor     // 모든 필드를 받는 생성자
@RequiredArgsConstructor    // Final Field를 초기화하는 생성자
public class MyBean034 {
    private String home;
    private final Integer age;

}
