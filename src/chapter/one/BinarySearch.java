package chapter.one;

/**
 * 说明：此类用于二分法示例。
 * @author Raphael Cha
 * @version 1.0
 */
public class BinarySearch {
    /**
     * 作用：通过二分法求一个数组中的指定值的下标值。
     * @param list 指定数组。
     * @param item 数组中的指定值。
     * @return 若指定值存在于该数组中，则最终返回其下标；否则，返回-1。
     */
    public static int binarySearch(int[] list, int item) {
        int low = 0;
        int high = list.length - 1;

        while (low <= high) {
            int middle = (low + high) / 2;
            int guess = list[middle];

            if (guess == item) {
                return middle;
            } else if (guess > item) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ints = {1, 3, 5, 7, 9};

        System.out.println(binarySearch(ints, 3));
        System.out.println(binarySearch(ints, -1));
    }
}