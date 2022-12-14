package study.yjpark.chapter09.item63;

import org.springframework.util.StopWatch;

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
        final int numItems = 100;
        StopWatch stopWatch = new StopWatch("문자열 연결 비교 : 100개");

        // [1] 문자열 연결을 잘못 사용한 예
        {
            stopWatch.start("문자열 연결 연산자");
            String result = "";
            for (int i = 0; i < numItems; ++i) {
                result += "string plus operation";
            }
            stopWatch.stop();
        }

        // [2] StringBuilder 성능 개선
        {
            stopWatch.start("StringBuilder 문자열 연결");
            StringBuilder result = new StringBuilder(16);
            for (int i = 0; i < numItems; ++i) {
                result.append("string plus operation");
            }
            stopWatch.stop();
        }
        System.out.println(stopWatch.prettyPrint());
    }
}