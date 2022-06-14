package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Code29 {

    @Test
    public void test1() {
        var num1 = new int[]{1, 2, 3, 0, 0, 0};
        merge(num1, 3, new int[]{2, 5, 6}, 3);
        Assertions.assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, num1);
    }

    @Test
    public void test2() {
        var num1 = new int[]{0};
        merge(num1, 0, new int[]{1}, 1);
        Assertions.assertArrayEquals(new int[]{1}, num1);
    }

    @Test
    public void test3() {
        var num1 = new int[]{1, 0};
        merge(num1, 1, new int[]{1}, 1);
        Assertions.assertArrayEquals(new int[]{1, 1}, num1);
    }

    @Test
    public void test4() {
        var num1 = new int[]{4, 0, 0, 0, 0, 0};
        merge(num1, 1, new int[]{1, 2, 3, 5, 6}, 5);
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, num1);
    }

    int m = 0;

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0 && n == 0) {
            return;
        }
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        this.m = m;

        for (int i = 0; i < n; i++) {
            // 取nums2的值
            int num = nums2[i];
            insertNums1(nums1, this.m, num);
        }


    }

    /**
     * 找到num中比 >=2的index,插入数组中,移动数组位置
     */
    private void insertNums1(int[] nums1, int m, int num) {
        for (int i = 0, len = nums1.length; i < len; i++) {
            int num1 = nums1[i];
            if (i < this.m) {
                if (num1 > num) {
                    // 将array向后移动1位
                    int[] dest = new int[len];
                    System.arraycopy(nums1, 0, dest, 0, i);
                    dest[i] = num;
                    System.arraycopy(nums1, i, dest, i + 1, len - i - 1);
                    System.arraycopy(dest, 0, nums1, 0, len);
                    this.m++;
                    return;
                }
            } else if (nums1[i] == 0) {
                nums1[i] = num;
                this.m++;
                return;
            }
        }
    }
}
