package study.yjpark.chapter06.item42;

public class Test {
    private final int value = 100;

    // 익명 클래스
    public LambdaTest anonymous = new LambdaTest() {

        final int value = 200;

        @Override
        public String getValue() {
            System.out.println("this = " + this);
            return "익명 클래스의 value : " + this.value;
        }
    };
    // 람다
    public LambdaTest lambda = () -> {
        final int value = 300;
        System.out.println("this = " + this);
        return "람다의 value : " + this.value;
    };

    public static void main(String[] args) {
        Test test = new Test();
        test.anonymous.getValue();
        System.out.println(test.anonymous.getValue());
        System.out.println(test.lambda.getValue());
    }
}
