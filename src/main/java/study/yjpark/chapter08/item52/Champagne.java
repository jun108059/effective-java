package study.yjpark.chapter08.item52;

/**
 * 재정의된 메서드 호출 메커니즘 (Page 313 : 코드 52-2)
 */
class Champagne extends SparklingWine {
    @Override
    String name() {
        return "champagne";
    }
}