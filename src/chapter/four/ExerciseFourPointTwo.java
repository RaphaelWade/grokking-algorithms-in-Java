package chapter.four;

import java.util.ArrayList;

public class ExerciseFourPointTwo {
    public static int countElements(ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            return 0;
        }
        arrayList.remove(0);

        return 1 + countElements(arrayList);
    }

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Frank");
        arrayList.add("Jack");
        arrayList.add("Lily");
        arrayList.add("Bill");
        arrayList.add("Kali");

        System.out.println(countElements(arrayList));
    }
}
