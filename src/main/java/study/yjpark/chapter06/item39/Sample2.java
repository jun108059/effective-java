package study.yjpark.chapter06.item39;

import java.util.ArrayList;
import java.util.List;

public class Sample2 {
    @ExceptionTest(ArithmeticException.class)
    public static void m1() { // 성공해야 함
        int i = 0;
        i = i / i;
    }
    @ExceptionTest(ArithmeticException.class)
    public static void m2() { // 실패해야 함 (다른 예외 발생)
        int[] a = new int[0];
        int i = a[1];
    }
    @ExceptionTest(value=ArithmeticException.class)
    public static void m3() {} // 실패해야 함 (예외가 발생하지 않음)

    @ExceptionTest({ IndexOutOfBoundsException.class, NullPointerException.class} )
    public static void m4() { // 성공해야 함
        // IndexOutOfBoundsException 또는 NullPointerException 발생
        List<String> list = new ArrayList<>();
        list.addAll(5, null);
    }
}
