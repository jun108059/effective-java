package study.yjpark.chapter07.item43;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Item43 {
    public static void main(String[] args) {
        Set<String> keySet = new HashSet<>();
        keySet.add("apple");
        keySet.add("banana");
        keySet.add("lemon");

        Map<String, Integer> map = new HashMap<>();
        for (String key : keySet) {
            MultiSet.add(key, map);
        }

        MultiSet.add("melon", map);
        MultiSet.add("apple", map);

        System.out.println("map = " + map);
    }

    static class MultiSet {

        static void add(String key, Map<String, Integer> map) {
            map.merge(key, 1, Integer::sum);
        }
    }
}
