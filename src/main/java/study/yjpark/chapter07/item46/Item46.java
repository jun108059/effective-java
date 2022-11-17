package study.yjpark.chapter07.item46;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

/**
 * 빈도표(Frequency table) 예제 코드
 */
public class Item46 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(args[0]);

        // [46-1] 스트림 패러다임을 이해하지 못한 채 API만 사용 (Do not use)
        Map<String, Long> freq = new HashMap<>();
        try (Stream<String> words = new Scanner(file).tokens()) {
            words.forEach(word -> {
                freq.merge(word.toLowerCase(), 1L, Long::sum);
            });
        }

        // [46-2] 스트림을 제대로 활용해 빈도표를 초기화
        Map<String, Long> freq2;
        try (Stream<String> words = new Scanner(file).tokens()) {
            freq2 = words
                    .collect(groupingBy(String::toLowerCase, counting()));
        }

        System.out.println(freq2);

        // [46-3] 빈도표에서 가장 흔한 단어 10개 추출하는 파이프라인
        List<String> topTen = freq2.keySet().stream()
                .sorted(comparing(freq2::get).reversed())
                .limit(10)
                .collect(toList());

        System.out.println(topTen);
    }
}
