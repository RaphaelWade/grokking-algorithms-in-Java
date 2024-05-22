package chapter.seven;

import java.util.ArrayList;
import java.util.HashMap;

public class DijkstraAlgorithmImplementation {
    // 需要一个数组用来记录处理过的节点。
    static ArrayList<String> processed = new ArrayList<>();

    public static void main(String[] args) {
        run();
    }

    static void run() {
        // 先用一个散列表实现整个图
        HashMap<String, HashMap<String, Integer>> graph = new HashMap<>();
        HashMap<String, Integer> fromStartInsideGraph = new HashMap<>();

        // 初始化起点的所有邻居和到这些邻居的权值
        fromStartInsideGraph.put("a", 6);
        fromStartInsideGraph.put("b", 2);
        graph.put("start", fromStartInsideGraph);

        // 获取起点的所有邻居
//        Set<String> keysFromStartInsideGraph = fromStartInsideGraph.keySet();
//        System.out.println(keysFromStartInsideGraph);

        // 获取起点到所有邻居的边的权重
//        for (Integer value : graph.get("start").values()) {
//            System.out.print(value + " ");
//        }
//        System.out.println();

        HashMap<String, Integer> fromAInsideGraph = new HashMap<>();

        // 初始化A点的所有邻居和到这些邻居的权值
        fromAInsideGraph.put("fin", 1);
        graph.put("a", fromAInsideGraph);

        // 获取A点的所有邻居
//        Set<String> keysFromAInsideGraph = fromAInsideGraph.keySet();
//        System.out.println(keysFromAInsideGraph);

        // 获取A点到所有邻居的边的权重
//        for (Integer value : graph.get("a").values()) {
//            System.out.print(value + " ");
//        }
//        System.out.println();

        HashMap<String, Integer> fromBInsideGraph = new HashMap<>();

        // 初始化B点的所有邻居和到这些邻居的权值
        fromBInsideGraph.put("a", 3);
        fromBInsideGraph.put("fin", 5);
        graph.put("b", fromBInsideGraph);

        // 获取B点的所有邻居
//        Set<String> keysFromBInsideGraph = fromBInsideGraph.keySet();
//        System.out.println(keysFromBInsideGraph);

        // 获取B点到所有邻居的边的权重
//        for (Integer value : graph.get("b").values()) {
//            System.out.print(value + " ");
//        }

        // 因为终点没有邻居，所以我直接存储了null。但是注意防止调用时报出空指针异常。
        graph.put("fin", null);

        // 接着用一个散列表存储每个节点的开销
        HashMap<String, Integer> costs = new HashMap<>();
        costs.put("a", 6);
        costs.put("b", 2);
        costs.put("fin", Integer.MAX_VALUE); // 我用Integer的最大值代替了无穷大

        // 还需要创建一个散列表来存储父节点
        HashMap<String, String> parents = new HashMap<>();
        parents.put("a", "start");
        parents.put("b", "start");
        parents.put("fin", null);

        System.out.println(getLowestCost(graph, costs, parents));
    }

    /**
     * 此方法实现狄克斯特拉算法，遍历图中的所有节点，不断更新最小开销和父节点，返回到目标节点的最小开销值。
     * @param graph 为所有节点建立的一种关系模型。
     * @param costs 存储所有开销信息的散列表。
     * @param parents 存储所有节点和其对应的父节点。
     * @return 返回从开始节点到目标节点的最小开销值。
     */
    static int getLowestCost(HashMap<String, HashMap<String, Integer>> graph, HashMap<String, Integer> costs, HashMap<String, String> parents) {
        // 接下来实现算法
        String node = findLowestCostNode(costs);
        while (node != null) {
            int cost = costs.get(node);
            if (graph.get(node) != null) {
                HashMap<String, Integer> neighbors = graph.get(node);
                for (String value : neighbors.keySet()) {
                    int newCost = cost + neighbors.get(value);
                    if (costs.get(value) > newCost) {
                        costs.put(value, newCost);
                        parents.put(value, node);
                    }
                }
            }
            processed.add(node);
            node = findLowestCostNode(costs);
        }
        return costs.get("fin");
    }

    /**
     * 此方法遍历开销散列表中的所有节点，每次返回开销最小的节点。
     * @param costs 存储所有开销信息的散列表。
     * @return 开销散列表中开销最小的节点。
     */
    static String findLowestCostNode(HashMap<String, Integer> costs) {
        int lowestCost = Integer.MAX_VALUE;
        String lowestCostNode = null;
        for (String node : costs.keySet()) {
            int cost = costs.get(node);
            if (cost < lowestCost && !processed.contains(node)) {
                lowestCost = cost;
                lowestCostNode = node;
            }
        }
        return lowestCostNode;
    }
}
