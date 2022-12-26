# 아이템66. 네이티브 메서드는 신중히 사용하라

## 1. 네이티브 메서드란?

- **C, C++** 와 같은 네이티브 프로그래밍 언어로 작성한 메서드
- 자바 프로그램에서 네이티브 메서드를 호출하는 기술을 JNI(Java Native Interface)라고 함

```java
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
```

## 2. 네이티브 메서드가 사용되는 곳

1. **플랫폼 특화 기능**이 필요할 때 *`(ex.System Call, File Lock)`*
    - 하지만 Java의 발전으로 인해, 플랫폼 기능을 대체할 자바 라이브러리 많아지고 있음
    - ex) Java9 의 process API는 OS 프로세스에 접근 가능
2. 네이티브 코드로 작성된 기존(레거시) 라이브러리가 필요 할 때
3. 성능에 결정적인 영향을 주는 부분
    - 이 또한, JVM의 발전으로 네이티브 구현보다 훨씬 나은 성능을 제공하기도 함
    - 대부분 성능 개선 목적으로 네이티브 메소드 사용은 권장하지 않음
4. GNU 다중 정밀 연산 라이브러리(GMP) 필요 시

## 3. 네이티브 메서드의 단점

- **안전하지 않다**
    - 네이티브 메서드를 사용하는 애플리케이션도 메모리 훼손 오류로부터 안전하지 않다 (아이템50 : 적시에 방어적 복사본을 만들라)
- **이식성이 낮다**
    - Java는 이식성이 높은 언어이기 때문에, 해당 플랫폼에 적합한 JVM 만 있다면 플랫폼 독립적인 바이트 코드를 실행 하는 것이 가능
    - 따라서 native method를 사용하면, 해당 프로그램 자체의 이식성이 낮아진다
    - 반면, 해당 플랫폼에서 컴파일된 C , C++ 프로그램은 해당 플랫폼에서만 실행 가능
- **Native memory 는 GC 에 의해 자동 회수 되지 못하며 추정도 불가능하다**
- **Java 코드와 네이티브 코드의 경계를 넘나드는데 비용이 든다**
    - Java 코드와 네티이브 코드 사이의 `접착 코드(glue code)`가 필요(추가 작업이 필요)
    - 가독성도 떨어짐

## 4. 정리

성능 향상을 기대하며 네이티브 메소드 사용을 고려하는 경우가 많을 것이다. 하지만 실질적으로 네이티브 메소드가 성능 향상을 가져다 주는 경우는 매우 드물기 때문에 함부로 사용해서는 안 된다.

따라서 최소한의 네이티브 메소드를 사용하고, 이에 대해 철저히 테스트 해야 한다.

**Reference**

- [이펙티브자바 서적](http://www.yes24.com/Product/Goods/65551284)