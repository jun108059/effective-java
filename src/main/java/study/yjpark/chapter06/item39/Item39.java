package study.yjpark.chapter06.item39;

public class Item39 {
    public static void main(String[] args) {
        try {
            // 마커 애너테이션 테스트
            RunTests.test(new String[] { Sample1.class.getName() });

            // 배열 매개변수 애너테이션 테스트
            RunTests.test2(new String[] { Sample2.class.getName() });

            // 반복 가능한 애너테이션 테스트
            RunTests.test3(new String[] { Sample3.class.getName() });
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
