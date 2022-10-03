package study.yjpark.chapter04.item19;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serial;
import java.io.Serializable;

public class SerializableFoo implements Serializable {

    @Serial
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        overrideMe();
    }

    public void overrideMe() {
        System.out.println("This is SuperFoo's overrideMe");
    }
}