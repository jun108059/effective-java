package study.yjpark.chapter04.item19.SideEffect;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StarbucksTest {

    @Test
    void 기본_원두_테스트() {
        // 스타벅스의 기본 원두를 선택
        String beanType = "default";
        Starbucks starbucks = new Starbucks(beanType);
        String beanKind = starbucks.getBeanKind();
        System.out.println("Starbucks bean kind = " + beanKind);
        assertEquals(beanKind, "arabica");

        // 커피 기본 원두 : 로부스타
        Coffee coffee = new Coffee();
        String type = coffee.decideBean("default");
        assertEquals(type, "robusta");
    }

}