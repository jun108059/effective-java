package study.yjpark.chapter10;

/**
 * [Item69] 예외는 진짜 예외 상황에서만 사용하라
 * <p>
 * [핵심]
 * 예외는 예외 상황에서 쓸 의도로 설계되었다.
 * 정상적인 제어 흐름에서 사용해서는 안 되며, 이를 개발자에게 강요하는 API를 만들어서도 안 된다.
 * <p>
 * 잘 설계된 API라면 클라이언트가 정상적인 제어 흐름에서 예외를 사용할 일이 없게 해야한다.
 */

public class Item69 {

    public static void main(String[] args) {
        String[] array = new String[] { "1", "2", "3", "4", "5" };
        try {
            int i = 0;
            while (true) {
                array[i++].length();
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {}

        // 성능을 향상시킨다고 이런 코드를 작성하지 말라.
        // 대부분의 경우 훨씬 느려지고 가독성도 매우 좋지 않다.

        for (String s : array) {
            s.length();
        }

        // 아래 코드랑 위 코드의 기능은 완전히 일치하지만,
        // 가독성과 성능면에서 아래 코드가 훨씬 유리하다.

        // 1. 예외는 예외 상황에 쓸 용도로 설계되어서 JVM 구현자 입장에서는
        //    명확한 검사만큼 빠르게 만들어야 할 동기가 약하다.
        // 2. 코드를 try-catch 블록 안에 넣으면 JVM이 제공할 수 있는 최적화가 제한된다.
        // 3. 배열을 순회하는 표준 관용구는 앞서 걱정한 중복 검사를 수행하지 않는다.
        //    JVM이 알아서 최적화해 없애준다.
    }
}