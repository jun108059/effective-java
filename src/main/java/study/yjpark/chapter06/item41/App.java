package study.yjpark.chapter06.item41;

import study.yjpark.chapter03.item12.Member;

import java.io.*;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        OutPutStreamSample sample = new OutPutStreamSample(
                "youngjun108059@gmail.com",
                "password",
                28);

        byte[] serializedSample;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {

            oos.writeObject(sample);
            // 직렬화 안되는 타입을 넣으면 RuntimeException 발생
            // Member m = new Member(1L, "d", 23);
            // oos.writeObject(m);

            // 직렬화된 Sample 객체
            serializedSample = baos.toByteArray();
            System.out.println("serializedSample = " + Arrays.toString(serializedSample));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ByteArrayInputStream bais = new ByteArrayInputStream(serializedSample);
        try (ObjectInputStream ois = new ObjectInputStream(bais)) {

            // 역직렬화된 Sample 객체 읽기
            Object objectSample = ois.readObject();
            OutPutStreamSample sampleDeserialized = (OutPutStreamSample) objectSample;

            System.out.println("sampleDeserialized = " + sampleDeserialized);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
