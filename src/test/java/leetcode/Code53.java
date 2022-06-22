package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Code53 {

    @Test
    public void test() {
        Assertions.assertEquals(6, maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    @Test
    public void test1() {
        Assertions.assertEquals(1, maxSubArray(new int[]{1}));
    }

    @Test
    public void test2() {
        Assertions.assertEquals(23, maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = nums.length; i > 0; i--) {
            int sum = maxSumSub(nums, i);
            max = Math.max(sum, max);
        }
        return max;
    }

    int maxSumSub(int[] arr, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum = arr[i] + sum;
        }
        int max = sum;
        for (int i = k, len = arr.length; i < len; i++) {
            sum = sum - arr[i - k] + arr[i];
            max = Math.max(sum, max);
        }
        return max;
    }
}
