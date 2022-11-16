package study.yjpark.chapter07.item45;

/**
 * char 값들을 스트림으로 처리하면 발생하는 문제
 */
public class CharStream {
    public static void main(String[] args) {
        // 원하는 출력(Hello world!)을 얻지 못함
        "Hello world!".chars().forEach(System.out::print);
        System.out.println();

        // 명시적 형변환을 통해 원하는 결과 출력
        "Hello world!".chars().forEach(x -> System.out.print((char) x));
        System.out.println();
    }
}
