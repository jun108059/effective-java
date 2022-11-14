package study.yjpark.chapter06.item39;

import java.util.ArrayList;
import java.util.List;

public class Sample3 {
    @ExceptionTest2(IndexOutOfBoundsException.class)
    @ExceptionTest2(NullPointerException.class)
    public static void m1() { // 성공해야 한다
        List<String> list = new ArrayList<>();
        list.addAll(5, null);
    }
}
