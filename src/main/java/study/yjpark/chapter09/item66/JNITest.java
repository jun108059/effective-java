package study.yjpark.chapter09.item66;

public class JNITest {
    static {
        // Native Library Load
        System.loadLibrary("libhello.so");
    }

    // 네이티브 메서드 선언, 구현 코드는 C, C++언어 기반
    private native void sayHello();

    public static void main(String[] args) {
        // 인스턴스 생성, 네이티브 메서드 호출
        new JNITest().sayHello();

    }
}