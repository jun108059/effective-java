package study.yjpark.chapter06.item39;

import java.lang.annotation.*;

/**
 * 반복 가능한 애너테이션 타입
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(ExceptionTest2Container.class)
public @interface ExceptionTest2 {
    // 명시한 예외를 던져야만 성공하는 테스트 메서드용 애너테이션
    Class<? extends Throwable> value();
}
