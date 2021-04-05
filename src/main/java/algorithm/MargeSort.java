package algorithm;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MargeSort {

    public static void main(String[] args) {
        MargeSort margeSort = new MargeSort();
        int[] arr = {5, 4, 2, 1, 3};
        int[] sort = margeSort.sort(arr);
        Arrays.stream(sort).forEach(System.out::println);
    }

    public int[] sort(int[] arr) {

        if (arr == null || arr.length == 1) {
            return arr;
        }

        if (arr.length == 2) {
            if (arr[0] > arr[1]) {
                int tmp = arr[0];
                arr[0] = arr[1];
                arr[1] = tmp;
            }
            return arr;
        }

        int index = arr.length / 2;
        int[] left = sort(Arrays.copyOfRange(arr, 0, index));
        int[] right = sort(Arrays.copyOfRange(arr, index, arr.length));

        int[] array = new int[arr.length];
        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = 0; i < array.length; i++) {

            if (left.length <= leftIndex) {
                array[i] = right[rightIndex];
                rightIndex++;
                continue;
            }
            if (right.length <= rightIndex) {
                array[i] = left[leftIndex];
                leftIndex++;
                continue;
            }

            if (left[leftIndex] > right[rightIndex]) {
                array[i] = right[rightIndex];
                rightIndex++;
            }
            else {
                array[i] = left[leftIndex];
                leftIndex++;
            }
        }
        return array;
    }
}
