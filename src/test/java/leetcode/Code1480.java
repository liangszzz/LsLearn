package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Code1480 {

    @Test
    public void test() {
        Assertions.assertArrayEquals(new int[]{1, 3, 6, 10}, runningSum(new int[]{1, 2, 3, 4}));
    }

    @Test
    public void test2() {
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, runningSum(new int[]{1, 1, 1, 1, 1}));
    }

    @Test
    public void test3() {
        Assertions.assertArrayEquals(new int[]{3, 4, 6, 16, 17}, runningSum(new int[]{3, 1, 2, 10, 1}));
    }

    public int[] runningSum(int[] nums) {
        for (int i = 1, len = nums.length; i < len; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        return nums;
    }
}
