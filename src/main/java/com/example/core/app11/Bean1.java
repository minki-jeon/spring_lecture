package com.example.core.app11;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor    // 생성자 DI (3) (// final 필드를 파라미터로 받는 생성자 자동 생성하는 lombok 어노테이션에 의해)
//* 의존성 주입(DI) 중에서 가장 권장되는 방법: 생성자DI (가장 안정적)
public class Bean1 {
    final Bean2 bean2;

    public void some() {
        bean2.crud();
    }
}
