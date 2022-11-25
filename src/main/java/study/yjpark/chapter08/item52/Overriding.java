package study.yjpark.chapter08.item52;

import java.util.List;

/**
 * 재정의된 메서드 호출 메커니즘 (Page 313 : 코드 52-2)
 */
class Overriding extends Wine {
    public static void main(String[] args) {
        List<Wine> wineList = List.of(
                new Wine(), new SparklingWine(), new Champagne());

        for (Wine wine : wineList)
            System.out.println(wine.name());
    }
}