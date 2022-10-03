package study.yjpark.chapter04.item19;

import java.time.Instant;

public class Sub extends Super {
    // 초기화되지 않은 final 필드
    private final Instant instant;

    public Sub() {
        instant = Instant.now();
    }

    @Override
    public void overrideMe() {
        System.out.println("Sub overrideMe Method!! " + instant);
    }
}
