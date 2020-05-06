package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * let code
 * <p>
 * 定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code1 {

    @Test
    public void test() {
        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 15};
        int[] ints = solution.twoSum(nums, 9);
        System.out.println(Arrays.toString(ints));

    }

    @Test
    public void test1() {
        Solution solution = new Solution();
        int[] nums = {3, 3};
        int[] ints = solution.twoSum(nums, 6);
        Assert.assertArrayEquals(ints, new int[]{0, 1});
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        int[] nums = {3, 2, 4};
        int[] ints = solution.twoSum(nums, 6);
        Assert.assertArrayEquals(ints, new int[]{1,2});
    }

    @Test
    public void test3() {
        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 15};
        int[] ints = solution.twoSum(nums, 9);
        Assert.assertArrayEquals(ints, new int[]{0, 1});
    }

    @Test
    public void test4() {
        Solution solution = new Solution();
        int[] nums = {3, 2, 4};
        int[] ints = solution.twoSum(nums, 6);
        Assert.assertArrayEquals(ints, new int[]{1, 2});
    }

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int len = nums.length;
            HashMap<Integer, Integer> map = new HashMap<>(nums.length);
            for (int i = 0; i < len; i++) {
                int val = nums[i];
                int other = target - val;
                if (map.containsKey(other)) {
                    return new int[]{map.get(other), i};
                } else {
                    map.put(val, i);
                }
            }
            return null;
        }
    }


    class Solution1 {
        public int[] twoSum(int[] nums, int target) {
            int[] arr = new int[2];
            int len = nums.length;
            int mid = target / 2;
            for (int i = 0; i < len; i++) {
                if (nums[i] > (mid)) continue;
                for (int j = 0; j < len; j++) {
                    if (nums[j] < (mid)) continue;
                    if (nums[i] + nums[j] == target) {
                        if (i == j) continue;
                        arr[0] = i;
                        arr[1] = j;
                        return arr;
                    }
                }
            }
            return arr;
        }
    }


    class Solution0 {
        public int[] twoSum(int[] nums, int target) {

            int[] arr = new int[2];

            for (int i = 0; i < nums.length; i++) {

                for (int j = 0; j < nums.length; j++) {

                    if (nums[i] + nums[j] == target) {
                        if (i == j) {
                            continue;
                        }
                        arr[0] = i;
                        arr[1] = j;
                        return arr;
                    }
                }
            }
            return arr;
        }
    }
}
