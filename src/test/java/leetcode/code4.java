package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code4 {

    Solution solution = new Solution();

    @Test
    public void test0() {

        double medianSortedArrays = solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        Assert.assertEquals(medianSortedArrays, 2.0, 0.5);

    }

    @Test
    public void test1() {

        double medianSortedArrays = solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        Assert.assertEquals(medianSortedArrays, 2.5, 0.5);

    }


    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len = nums1.length + nums2.length;
            List<Integer> list = new ArrayList<>(len);

            int index = 0;

            for (int a : nums1) {
                while (index < nums2.length && a > nums2[index]) {
                    list.add(nums2[index]);
                    index++;
                }
                list.add(a);
            }

            for (; index < nums2.length; index++) {
                list.add(nums2[index]);
            }

            //取中位数
            if (len % 2 == 0) {
                double sum = list.get((len + 1) / 2 - 1) + list.get((len - 1) / 2 + 1);
                return sum / 2;
            } else {
                return list.get(len / 2);
            }
        }
    }

    static class Solution1 {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len = nums1.length + nums2.length;
            List<Integer> list = new ArrayList<>(len);
            int index = 0, last;

            if (len % 2 == 0) {
                last = (len / 2) + 1;
            } else {
                last = (len + 1) / 2;
            }

            for (int a : nums1) {
                if (list.size() >= last) {
                    break;
                }
                while (index < nums2.length && a > nums2[index]) {
                    list.add(nums2[index]);
                    index++;
                }
                list.add(a);
            }

            for (; index < nums2.length; index++) {
                if (list.size() >= last) {
                    break;
                }
                list.add(nums2[index]);
            }

            //取中位数
            if (len % 2 == 0) {
                double sum = list.get(last - 1) + list.get(last - 2);
                return sum / 2;
            } else {
                return list.get(last - 1);
            }
        }
    }
}
