package chapter.six;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Raphael Cha
 */
public class BreadthFirstSearch {
    // 一个哈希表类变量，用来存储图，供整个类的所有方法调用。
    static HashMap<String, String[]> hashMap = new HashMap<>();

    /**
     * 此方法使用广度优先法查询图中是否含有某个目标对象。
     * @param name 指定图遍历的起始节点。
     * @return 如果图中含有某个目标对象，则返回true，否则返回false。
     */
    public static boolean search(String name) {
        ArrayDeque<String> searchQueue = new ArrayDeque<>();
        ArrayList<String> searched = new ArrayList<>();

        searchQueue.addAll(Arrays.asList(hashMap.get("you")));

        while (!searchQueue.isEmpty()) {
            String person = searchQueue.pop();
            if (!searched.contains(person)) {
                if (personIsSeller(person)) {
                    System.out.println(person + " is a mango seller!");
                    return true;
                } else {
                    // 防止出现空指针异常。
                    if (hashMap.get(person) != null) {
                        searchQueue.addAll(Arrays.asList(hashMap.get(person)));
                        searched.add(person);
                    }
                }
            }
        }
        return false;
    }

    /**
     * 此方法判断某个输入字符串是否以字符'm'结尾。
     * @param name 要进行操作的人名。
     * @return 如果该人名是以字符'm'结尾，则返回true，否则返回false。
     */
    public static boolean personIsSeller(String name) {
        return name.toCharArray()[name.length() - 1] == 'm';
    }

    static void run() {
        String[] myFriends = {"alice", "bob", "claire"};
        String[] aliceFriends = {"peggy"};
        String[] bobFriends = {"anuj", "peggy"};
        String[] claireFriends = {"thom", "jonny"};

        hashMap.put("you", myFriends);
        hashMap.put("alice", aliceFriends);
        hashMap.put("bob", bobFriends);
        hashMap.put("claire", claireFriends);
        hashMap.put("anuj", null);
        hashMap.put("peggy", null);
        hashMap.put("thom", null);
        hashMap.put("jonny", null);

        search("you");
    }

    public static void main(String[] args) {
        run();
    }
}
/*
输出：
    thom is a mango seller!

 */