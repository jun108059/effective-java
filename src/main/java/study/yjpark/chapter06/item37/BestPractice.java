package study.yjpark.chapter06.item37;

import java.util.*;

public class BestPractice {
    // 정원에 꽃 List
    static List<Plant> garden = new ArrayList<>() {
        {
            add(new Plant("호박", Plant.LifeCycle.ANNUAL));
            add(new Plant("나팔꽃", Plant.LifeCycle.ANNUAL));
            add(new Plant("국화", Plant.LifeCycle.PERENNIAL));
            add(new Plant("보리", Plant.LifeCycle.BIENNIAL));
            add(new Plant("완두", Plant.LifeCycle.BIENNIAL));

        }
    };
    public static void main(String[] args) {
        // EnumMap 타입으로 데이터와 열거 타입 매핑
        Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle =
                new EnumMap<>(Plant.LifeCycle.class);

        for (Plant.LifeCycle lc : Plant.LifeCycle.values()) {
            plantsByLifeCycle.put(lc, new HashSet<>());
        }
        for (Plant p : garden) {
            plantsByLifeCycle.get(p.lifeCycle).add(p);
        }
        System.out.println(plantsByLifeCycle);

    }
}
