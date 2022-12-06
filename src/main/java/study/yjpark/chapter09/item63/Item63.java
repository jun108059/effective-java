package study.yjpark.chapter09.item63;

/**
 * [Item63] 문자열 연결은 느리니 주의하라
 * <p>
 * 성능에 신경 써야 한다면, 문자열 연결 연산자(+)를 피하자.
 * 대신 StringBuilder append 메서드를 사용하라.
 * 문자 배열을 사용하거나, 문자열을 (연결하지 않고) 하나씩 처리하는 방법도 있다.
 * <p>
 * 문자열 연결 연산자로 문자열 n개를 잇는 시간은 n²에 비례한다.
 */
public class Item63 {


    public static void main(String[] args) {
        final int testCase = 10;

        // [1] 문자열 연결을 잘못 사용한 예
        {
            long bgnTime = System.currentTimeMillis();
            String result = "";
            for (int i = 0; i < testCase; ++i) {
                result += "attach_me!";
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Case1:");
            System.out.println("Time: " + (endTime - bgnTime) + "ms.");
        }

        // [2] StringBuilder 성능 개선
        {
            long bgnTime = System.currentTimeMillis();
            StringBuilder result = new StringBuilder(128);
            for (int i = 0; i < testCase; ++i) {
                result.append("attach_me!");
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Case2:");
            System.out.println("Time: " + (endTime - bgnTime) + "ms.");
        }
    }
}