package study.yjpark.chapter06.item39;

public class Sample1 {
    @Test public static void m1() {} // 성공해야 함
    public static void m2() {}
    @Test public static void m3() { // 실패해야 함
        throw new RuntimeException("실패");
    }
    public static void m4() {}
    @Test public void m5() {} // 잘못 사용한 예 : 정적 메서드가 아님
    public static void m6() {}
    @Test public static void m7() {
        throw new RuntimeException("실패");
    } // 실패해야 함
    public static void m8() {}
}
