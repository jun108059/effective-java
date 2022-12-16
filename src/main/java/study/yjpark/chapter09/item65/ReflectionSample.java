package study.yjpark.chapter09.item65;

public class ReflectionSample {

    public String str1 = "publicField";
    private String str2 = "privateField";

    public ReflectionSample() {

    }

    public int methodZero(int n) {
        System.out.println("methodZero = " + n);
        return n;
    }

    private int methodPrivate(int n) {
        System.out.println("methodPrivate = " + n);
        return n;
    }
}
