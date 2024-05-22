package chapter.eight;

import java.util.HashMap;
import java.util.HashSet;

public class RadioStationProblem {
    public static void main(String[] args) {
        // 创建一个集合，其中包含要覆盖的州
        HashSet<String> statesNeeded = new HashSet<>();
        statesNeeded.add("mt");
        statesNeeded.add("wa");
        statesNeeded.add("or");
        statesNeeded.add("id");
        statesNeeded.add("nv");
        statesNeeded.add("ut");
        statesNeeded.add("ca");
        statesNeeded.add("az");

        // 还需要有可供选择的广播台清单，用散列表来表示
        HashMap<String, HashSet<String>> stations = new HashMap<>();

        HashSet<String> kongIncludedStates = new HashSet<>();
        kongIncludedStates.add("id");
        kongIncludedStates.add("nv");
        kongIncludedStates.add("ut");

        HashSet<String> ktwoIncludedStates = new HashSet<>();
        ktwoIncludedStates.add("wa");
        ktwoIncludedStates.add("id");
        ktwoIncludedStates.add("mt");

        HashSet<String> kthreeIncludedStates = new HashSet<>();
        kthreeIncludedStates.add("or");
        kthreeIncludedStates.add("nv");
        kthreeIncludedStates.add("ca");

        HashSet<String> kfourIncludedStates = new HashSet<>();
        kfourIncludedStates.add("nv");
        kfourIncludedStates.add("ut");

        HashSet<String> kfiveIncludedStates = new HashSet<>();
        kfiveIncludedStates.add("ca");
        kfiveIncludedStates.add("az");

        stations.put("kong", kongIncludedStates);
        stations.put("ktwo", ktwoIncludedStates);
        stations.put("kthree", kthreeIncludedStates);
        stations.put("kfour", kfourIncludedStates);
        stations.put("kfive", kfiveIncludedStates);

        // 还需要一个集合 来存储最终选择的广播台
        HashSet<String> finalStations = new HashSet<>();

        // 接下来实现算法：
        while (!statesNeeded.isEmpty()) {
            String bestStation = null; // 这个变量保存覆盖了最多未覆盖州的广播台
            HashSet<String> statesCovered = new HashSet<>(); // 包含该广播台覆盖的所有未覆盖的州
            for (String station : stations.keySet()) {
                HashSet<String> states = stations.get(station);
                HashSet<String> covered = new HashSet<>(statesNeeded);
                covered.retainAll(states);
                if (covered.size() > statesCovered.size()) {
                    bestStation = station;
                    statesCovered = covered;
                }
            }
            // 在遍历完所有的广播站后，找到最合适的广播站，进行下面的操作：
            statesNeeded.removeAll(statesCovered);
            finalStations.add(bestStation);
        }

        System.out.println(finalStations);
    }
}
