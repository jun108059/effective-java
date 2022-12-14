package study.yjpark.chapter02.item07;
import java.util.Arrays;
import java.util.EmptyStackException;

/**
 *  [Item07] 다 쓴 객체 참조를 해제하라
 *  <p>
 *  [핵심]
 *  메모리 누수는 겉으로 잘 드러나지 않아 시스템에 수년간 잠복하는 사례도 있다.
 *  이런 메모리 누수는 철저한 코드 리뷰나 힙 프로파일러 같은 디버깅 도구를 동원해야만 발견되기도 한다.
 *  그래서 이런 종류의 문제는 예방법을 익혀두는 것이 매우 중요하다.
 */
public class Item07 {

    public static class Stack {
        private Object[] elements;
        private int size = 0;
        private static final int DEFAULT_INITIAL_CAPACITY = 16;

        public Stack() {
            elements = new Object[DEFAULT_INITIAL_CAPACITY];
        }

        public void push(Object e) {
            ensureCapacity();
            elements[size++] = e;
        }

        public Object pop() {
            if (size == 0) {
                throw new EmptyStackException();
            }

            // return elements[--size]; <- 메모리 누수 원인 코드

            // 특별히 문제는 없어보이지만, 메모리 누수가 발생한다.
            // 성능 저하 -> 디스크 페이징 or OutOfMemoryError 발생 가능성 있음
            // stack 사이즈를 줄였지만, 객체 참조는 그대로 유지된다.
            // 아래 코드와 같이 참조가 끝나면 null 처리(참조 해제)하면 된다.

            Object result = elements[--size];
            elements[size] = null; // 다 쓴 참조 해제
            return result;

            // 그렇다고 모든 객체 사용 후 null 처리하는 것은 바람직하지 않다.
            // 객체 참조를 null 처리하는 일은 예외적인 경우여야 한다.
            // 다 쓴 참조를 해제하는 가장 좋은 방법은 그 참조를 담은 변수를 scope 밖으로 밀어내는 것이다.
        }

        /**
         * 원소를 위한 공간을 적어도 하나 이상 확보한다.
         * 배열 크기를 늘려야 할 때마다 대략 두 배씩 늘린다.
         */
        private void ensureCapacity() {
            if (elements.length == size) {
                elements = Arrays.copyOf(elements, 2 * size + 1);
            }
        }
    }

}