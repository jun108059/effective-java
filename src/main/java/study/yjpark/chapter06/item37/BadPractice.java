package study.yjpark.chapter06.item37;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BadPractice {
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
        // 집합들을 Set 배열로 관리
        Set<Plant>[] plantsByLifeCycle =
                new Set[Plant.LifeCycle.values().length];
        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            plantsByLifeCycle[i] = new HashSet<>();
        }
        // 각 식물을 해당 집합에 추가
        for (Plant p : garden) {
            plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);
        }
        // 결과 출력
        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            System.out.printf("%s: %s%n",
                    Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
        }
    }
}
