package chapter.five;

import org.junit.Test;

import java.util.HashMap;

public class HashTableTest {
    @Test
    public void test1() {
        HashMap<String, Double> hashMap = new HashMap<>();

        hashMap.put("apple", 0.67);
        hashMap.put("milk", 1.49);
        hashMap.put("avocado", 1.49);

        System.out.println("hashMap = " + hashMap);

        System.out.println(hashMap.get("avocado"));
    }

    /**
     * 使用散列表实现一个电话簿
     */
    @Test
    public void test2() {
        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put("jenny", 8675309);
        hashMap.put("emergency", 911);

        System.out.println(hashMap.get("jenny"));
    }
}
