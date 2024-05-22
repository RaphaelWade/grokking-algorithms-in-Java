package chapter.eight;

import org.junit.Test;

import java.util.HashSet;

public class HashSetTest {
    @Test
    public void test1() {
        HashSet<String> fruits = new HashSet<>();
        fruits.add("avocado");
        fruits.add("tomato");
        fruits.add("banana");

        HashSet<String> vegetables = new HashSet<>();
        vegetables.add("beets");
        vegetables.add("carrots");
        vegetables.add("tomato");

        fruits.addAll(vegetables);

        System.out.println("并集：" + fruits);
    }

    @Test
    public void test2() {
        HashSet<String> fruits = new HashSet<>();
        fruits.add("avocado");
        fruits.add("tomato");
        fruits.add("banana");

        HashSet<String> vegetables = new HashSet<>();
        vegetables.add("beets");
        vegetables.add("carrots");
        vegetables.add("tomato");

        fruits.retainAll(vegetables);

        System.out.println("交集：" + fruits);
    }

    @Test
    public void test3() {
        HashSet<String> fruits = new HashSet<>();
        fruits.add("avocado");
        fruits.add("tomato");
        fruits.add("banana");

        HashSet<String> vegetables = new HashSet<>();
        vegetables.add("beets");
        vegetables.add("carrots");
        vegetables.add("tomato");

        fruits.removeAll(vegetables);

        System.out.println("差集：" + fruits);
    }
}
