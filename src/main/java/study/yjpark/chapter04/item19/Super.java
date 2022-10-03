package study.yjpark.chapter04.item19;

public class Super {
    // 잘못된 예 : 생성자가 재정의 가능 메서드 호출
    public Super() {
        overrideMe();
    }

    public void overrideMe() {
        System.out.println("Super overrideMe Method !");
    }
}
