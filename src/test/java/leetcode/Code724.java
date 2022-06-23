package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Code724 {

    @Test
    public void test() {
        Assertions.assertEquals(3, pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }

    @Test
    public void test1() {
        Assertions.assertEquals(-1, pivotIndex(new int[]{1, 2, 3}));
    }

    @Test
    public void test2() {
        Assertions.assertEquals(0, pivotIndex(new int[]{2, 1, -1}));
    }


    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int left = 0;
        int right = sum;
        for (int i = 0, len = nums.length; i < len; i++) {
            if (i == 0) {
                left = 0;
                right = sum - nums[0];
            } else if (i == len - 1) {
                left = sum - nums[len - 1];
                right = 0;
            } else {
                left = left + nums[i - 1];
                right = right - nums[i];
            }
            if (left == right) {
                return i;
            }
        }
        return -1;
    }
}
