package study.yjpark.chapter09.item65;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {
    public static void main(String[] args) throws
            ClassNotFoundException,
            NoSuchMethodException,
            InvocationTargetException,
            IllegalAccessException,
            NoSuchFieldException {
        // 1. class 찾기
        Class<?> clazz = Class.forName("study.yjpark.chapter09.item65.ReflectionSample");
        System.out.println("class = " + clazz.getName());

        // 2. constructor 찾기
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        System.out.println("constructor = " + constructor);

        // 3. Method 찾기
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("method = " + method);
        }

        // 4. Field 찾기
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field = " + field);
        }

        ReflectionSample sampleInstance = new ReflectionSample();

        // 5. Method 호출
        Method methodZero = clazz.getDeclaredMethod("methodZero", int.class);
        methodZero.invoke(sampleInstance, 10); // arg1 : 호출 객체, arg2 : 전달할 파라미터
        Method methodPrivate = clazz.getDeclaredMethod("methodPrivate", int.class);
        methodPrivate.setAccessible(true); // private 메서드 접근 가능 설정
        methodPrivate.invoke(sampleInstance, 20); // private 그대로 호출 시 IllegalAccessException 발생

        // 6. Field 변경
        Field str2 = clazz.getDeclaredField("str2");
        str2.setAccessible(true); // private 필드 접근 가능 설정
        str2.set(sampleInstance, "변경했지롱");
        System.out.println("changedStr2 = " + str2.get(sampleInstance));
    }
}
