package study.yjpark.chapter09.item65;

import org.springframework.util.StopWatch;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionSpeed {
    public static void main(String[] args) throws
            ClassNotFoundException,
            NoSuchMethodException,
            InvocationTargetException,
            IllegalAccessException,
            NoSuchFieldException, InstantiationException {
        StopWatch stopWatch = new StopWatch("리플렉션 성능 비교");

        stopWatch.start("리플렉션 Method 호출");
        Class<?> clazz = Class.forName("study.yjpark.chapter09.item65.ReflectionSample");
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        ReflectionSample sampleInstance = (ReflectionSample) constructor.newInstance();
        Method methodZero = clazz.getDeclaredMethod("methodZero", int.class);
        methodZero.invoke(sampleInstance, 30);
        stopWatch.stop();

        stopWatch.start("일반적인 Method 호출");
        ReflectionSample common = new ReflectionSample();
        common.methodZero(30);
        stopWatch.stop();

        System.out.println(stopWatch.prettyPrint());
    }
}
