package study.yjpark.chapter10.item73;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * [Item73] 추상화 수준에 맞는 예외를 던지라
 * <p>
 * [핵심]
 * 아래 계층의 예외를 예방하거나 스스로 처리할 수 없고, 그 예외를
 * 상위 계층에 그대로 노출하기 곤란하다면 예외 번역을 사용하라.
 * 이때 예외 연쇄를 이용하면 상위 계층에는 맥락에 어울리는 고수준 예외를
 * 던지면서 근본 원인도 함께 알려주어 오류를 분석하기에 좋다(Item75)
 */
public class Item73<E> {

    // [1] 상위 계층에서는 저수준 예외를 잡아 자신의 추상화 수준에 맞는 예외로 바꿔서 던지자
    // 이를 예외 번역(Exception Translation)이라고 한다
    /**
     * 이 리스트 안의 지정한 위치의 원소를 반환한다.
     * @throws IndexOutOfBoundsException index가 범위 밖이라면,
     *         즉 ({@code index < 0 || index >= size()}이면 발생한다.
     */
    public E get(int index) {
        List<E> innerList = new ArrayList<>();
        ListIterator<E> iter = innerList.listIterator();
        // [1] 예외 번역
        try {
            return iter.next();
        } catch (NoSuchElementException e) {
            throw new IndexOutOfBoundsException("인덱스: " + index);
        }
    }

    // [2] 예외 연쇄용 생성자
    public static class HigherLevelException extends Exception {

        @Serial
        private static final long serialVersionUID = 3512313924500949897L;

        HigherLevelException(Throwable cause) {
            super(cause);
        }
    }

    public static class LowerLevelException extends Exception {

        @Serial
        private static final long serialVersionUID = 6761033148084089360L;

        protected LowerLevelException(String msg) {
            super(msg);
        }
    }

    public static void main(String[] args) throws HigherLevelException {
        // [2] 예외 연쇄
        try {
            throw new LowerLevelException("저수준 예외 발생");
        } catch (LowerLevelException cause) {
            // 저수준 예외를 고수준 예외에 실어 보낸다.
            throw new HigherLevelException(cause);
            // cause.initCause(cause); Throwable 메서드를 사용하여 전달할 수도 있다
        }
    }
}