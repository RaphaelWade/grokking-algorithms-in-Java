package chapter.four;

import java.util.ArrayList;

public class ExerciseFourPointOne {
    public static int sum(ArrayList<Integer> arrayList) {
        int result = 0;

        if (arrayList.isEmpty()) {
            return result;
        }
        result = arrayList.get(0);
        arrayList.remove(0);

        return result + sum(arrayList);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        arrayList.add(9);
        arrayList.add(10);

        System.out.println(sum(arrayList));
    }
}
/*
输出：
    55

 */