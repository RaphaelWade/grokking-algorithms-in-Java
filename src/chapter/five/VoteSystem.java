package chapter.five;

import java.util.HashMap;

/**
 * 使用散列表实现一个简易的投票站管理系统
 */
public class VoteSystem {
    static HashMap<String, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) {
        check_voter("tom");
        check_voter("mike");
        check_voter("mike");
    }

    static void check_voter(String name) {
        if (hashMap.containsKey(name)) {
            System.out.println("Kick them out!");
        } else {
            hashMap.put(name, null);
            System.out.println("Let them vote!");
        }
    }
}
