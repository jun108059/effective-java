package study.yjpark.chapter09.item57;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Item57 {
    static List<String> sampleList = new ArrayList<>() {
        {
            add("abc");
            add("abc");
            add("abc");
            add("abc");
            add("abc");

        }
    };

    public static void main(String[] args) {
        for (String str : sampleList) {
            str = "1";
        }

        Iterator<String> iter = sampleList.iterator();
        while (iter.hasNext()) {
            iter.next();
        }
        Iterator<String> iter2 = sampleList.iterator();
        while (iter.hasNext()) {
            iter.next();
        }

        for (Iterator<String> i = sampleList.iterator(); i.hasNext();) {
            i.next();
        }

//        for (Iterator<String> i2 = sampleList.iterator(); i.hasNext();) {
//            i.next();
//        }

    }



}
