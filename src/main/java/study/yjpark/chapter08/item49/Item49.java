package study.yjpark.chapter08.item49;

import java.math.BigInteger;
import java.util.Objects;

/**
 * [Item49] 매개변수가 유효한지 검사하라
 *
 * 메서드나 생성자를 작성할 때면 그 매개변수들에 어떤 제약이 있을지 생각해야 한다.
 * 그 제약들을 문서화하고 메서드 코드 시작 부분에서 명시적으로 검사해야 한다.
 */
public class Item49 {
    // [49-1] 매개변수 제약과 예외를 문서화한 예제 코드
    /**
     * (현재 값 mod m) 값을 반환한다. <br> 이 메서드는
     * 항상 음이 아닌 BigInteger를 반환한다는 점에서 remainder 메서드와 다르다.
     *
     * @param exp 지수
     * @param m 계수(양수여야 한다.)
     * @return 현재 값 mod m
     * @throws ArithmeticException m이 0보다 작거나 같으면 발생한다.
     */
    public BigInteger mod(BigInteger exp, BigInteger m) {
        if (m.signum() <= 0) {
            throw new ArithmeticException("계수 (m)은 양수여야 합니다. " + m);
        }

        return m.modPow(exp, m);
    }

    public static void main(String[] args) {
        // [49-2] Java7에 추가된 java.util.Objects.requireNonNull 메서드를 통한 Null 체크
        String strategy = null;
        String param = null;
        strategy = Objects.requireNonNull(param, "매개변수가 null 입니다.");
    }

    // [49-3] 단언문(assert)을 사용한 재귀 정렬용 private Helper Method
    private static void sort(long a[], int offset, int length) {
        assert a != null;
        assert offset >= 0 && offset <= a.length;
        assert length >= 0 && length <= a.length - offset;

        // 생략 (연산 수행)
    }
}
