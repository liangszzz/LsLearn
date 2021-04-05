package algorithm;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {

        InsertSort insertSort = new InsertSort();
        int[] arr = {5, 4, 2, 1, 3};
        int[] sort = insertSort.sort(arr);
        Arrays.stream(sort).forEach(System.out::println);

    }


    public int[] sort(int[] arr) {

        if (arr == null || arr.length == 1) {
            return arr;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                int cur = arr[j];
                int pre = arr[j - 1];
                if (pre > cur) {
                    arr[j - 1] = cur;
                    arr[j] = pre;
                }
            }
        }
        return arr;
    }
}
