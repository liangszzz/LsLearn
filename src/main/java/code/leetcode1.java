package code;

import org.junit.Test;

/**
 *  两数之和
 * leetcode 1
 */
public class leetcode1 implements Test0 {


    @Test
    @Override
    public void test0() {
        int[] arr = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(arr[0] + ":" + arr[1]);
    }


    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
