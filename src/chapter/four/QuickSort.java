package chapter.four;

import java.util.ArrayList;

/**
 * @author Raphael Cha
 * @since 1.9
 * @version 1.0
 */
public class QuickSort {
    /**
     * 该方法传入一个包含Integer类型数据的ArrayList，对其进行快速排序。
     * @param arrayList 传入的包含Integer类型数据的ArrayList
     * @return 返回一个从小到大排好序的ArrayList
     */
    public static ArrayList<Integer> quickSort(ArrayList<Integer> arrayList) {
        if (arrayList.size() < 2) {
            // 基准条件
            return arrayList;
        } else {
            int pivot = arrayList.get(0);
            ArrayList<Integer> less = new ArrayList<>();
            ArrayList<Integer> greater = new ArrayList<>();

            for (int i = 1; i < arrayList.size(); i++) {
                if (arrayList.get(i) <= pivot)
                    less.add(arrayList.get(i));
            }
            for (int i = 1; i < arrayList.size(); i++) {
                if (arrayList.get(i) > pivot)
                    greater.add(arrayList.get(i));
            }
            ArrayList<Integer> result = new ArrayList<>(quickSort(less));
            result.add(pivot);
            result.addAll(quickSort(greater));

            return result;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(5);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(6);
        arrayList.add(1);
        arrayList.add(4);
        System.out.println(arrayList);

        System.out.println(quickSort(arrayList));
    }
}
