package study.yjpark.chapter08.item52;

import java.math.BigInteger;
import java.util.*;

/**
 * 컬렉션 분류기 - 오류 (Page 312 : 코드 52-1)
 * <p>
 * 재정의한 메서드는 동적으로 선택되고, 다중정의한 메서드는 정적으로 선택됨
 */
public class CollectionClassifier {
    public static String classify(Set<?> s) {
        return "Set";
    }

    public static String classify(List<?> lst) {
        return "List";
    }

    public static String classify(Collection<?> c) {
        return "Unknown Collection";
    }

    public static void main(String[] args) {
        // 컴파일타임에 어떤 메서드를 호출할지 결정 됨
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<BigInteger>(),
                new HashMap<String, String>().values()
        };

        for (Collection<?> c : collections)
            System.out.println(classify(c));

        // 결과
        // Unknown Collection
        // Unknown Collection
        // Unknown Collection
    }
}
