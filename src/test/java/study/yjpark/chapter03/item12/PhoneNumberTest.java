package study.yjpark.chapter03.item12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToStringInfoTest {

    @Test
    void 왜_틀렸다고_할까요() {

        Member infoA = new Member(1L, "영준",  28);
        Member infoB = new Member(2L, "영준",  28);

        assertEquals(infoA, infoB);
    }

}