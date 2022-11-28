package study.yjpark.chapter08.item56;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

// 문서화 주석 예제
public class DocExamples<E> {
    /**
     * 이 리스트에서 지정한 위치의 원소를 반환한다.
     *
     * <p>이 메서드는 상수 시간에 수행됨을 보장하지 <i>않는다</i>. 구현에 따라
     * 원소의 위치에 비례해 시간이 걸릴 수도 있다.
     *
     * @param index 반환할 원소의 인덱스; 0 이상이고 리스트 크기보다 작아야 한다.
     * @return 이 리스트에서 지정한 위치의 원소
     * @throws IndexOutOfBoundsException index가 범위를 벗어나면,
     *         즉, ({@code index < 0 || index >= this.size()})이면 발생한다.
     */
    E get(int index) {
        return null;
    }

    /**
     * 이 컬렉션이 비었다면 true를 반환한다.
     *
     * @implSpec
     * 이 구현은 {@code this.size() == 0}의 결과를 반환한다.
     *
     * @return 이 컬렉션이 비었다면 true, 그렇지 않으면 false
     */
    public boolean isEmpty() {
        return false;
    }

    /**
     * A geometric series converges if {@literal |r| < 1}.
     */
    public void fragment() {
    }

    /**
     * A suspect, such as Colonel Mustard or {@literal Mrs. Peacock}.
     */
    public enum FixedSuspect {
        MISS_SCARLETT, PROFESSOR_PLUM, MRS_PEACOCK, MR_GREEN, COLONEL_MUSTARD, MRS_WHITE
    }


    /**
     * This method complies with the {@index IEEE 754} standard.
     */
    public void fragment2() {
    }

    /**
     * An instrument section of a symphony orchestra.
     */
    public enum OrchestraSection {
        /** Woodwinds, such as flute, clarinet, and oboe. */
        WOODWIND,

        /** Brass instruments, such as french horn and trumpet. */
        BRASS,

        /** Percussion instruments, such as timpani and cymbals. */
        PERCUSSION,

        /** Stringed instruments, such as violin and cello. */
        STRING;
    }

    /**
     * Indicates that the annotated method is a test method that
     * must throw the designated exception to pass.
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface ExceptionTest {
        /**
         * The exception that the annotated test method must throw
         * in order to pass. (The test is permitted to throw any
         * subtype of the type described by this class object.)
         */
        Class<? extends Throwable> value();
    }
}