package chapter.two;

import java.util.ArrayList;

/**
 * @author Raphael Cha
 */
public class SelectionSort {
    /**
     * 作用：寻找一个指定整型数组集合的最小值。
     * @param arr 指定的整型数组集合。
     * @return 返回指定数组集合中的最小值的索引。
     */
    public static int findSmallest(ArrayList<Integer> arr) {
        Integer smallest = arr.get(0);
        int smallestIndex = 0;

        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < smallest) {
                smallest = arr.get(i);
                smallestIndex = i;
            }
        }

        return smallestIndex;
    }

    /**
     * 作用：给指定整型数组集合进行选择排序。
     * @param arr 指定的整型数组集合。
     * @return 返回一个排好序的整型数组集合。
     */
    public static ArrayList<Integer> selectionSort(ArrayList<Integer> arr) {
        ArrayList<Integer> newArr = new ArrayList<>();

        while (!arr.isEmpty()) {
            int smallest = arr.get(findSmallest(arr));
            newArr.add(smallest);
            // 此处一定要对remove()的参数进行装箱，否则IDE自动调用remove(index)，而不是remove(Object)，可能会导致数组越界的问题。
            arr.remove((Integer)smallest);
        }

        return newArr;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(5);
        arrayList.add(3);
        arrayList.add(6);
        arrayList.add(2);
        arrayList.add(10);

        for (Integer j : selectionSort(arrayList)) {
            System.out.printf("%d ", j);
        }
        System.out.println();
    }
}
/*
输出：
    2 3 5 6 10

 */