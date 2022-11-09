package study.yjpark.chapter06.item41;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@ToString
public class OutPutStreamSample implements Serializable {
    @Serial
    private static final long serialVersionUID = -2073279213197039699L;

    private String email;
    private transient String password;
    private int age;
}
