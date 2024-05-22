package chapter.six;

import java.util.HashMap;

public class ImplementationDiagramTest {
    public static void main(String[] args) {
        HashMap<String, String[]> hashMap = new HashMap<>();
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


        System.out.println(hashMap);
//        for (String value : hashMap.get("you")) {
//            System.out.print(value + " ");
//        }
    }
}
