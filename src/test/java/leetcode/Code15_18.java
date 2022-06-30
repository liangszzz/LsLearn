package leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Code15_18 {

    @Test
    public void Test() {
        List<List<Integer>> list = nSum(new int[]{2, 7, 11, 15}, 9, 2, new HashSet<>());
        System.out.println(list);
    }

    @Test
    public void Test3() {
        List<List<Integer>> list = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(list);
    }

    @Test
    public void Test4() {
        List<List<Integer>> list = fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296);
        System.out.println(list);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        return nSum(nums, 0, 3, new HashSet<>());
    }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        return nSum(nums, target, 4, new HashSet<>());
    }


    public List<List<Integer>> nSum(int[] nums, long target, int n, Set<Integer> skip) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < n) {
            return list;
        }
        if (n == 2) {
            Map<Long, Integer> map = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                if (skip.contains(i)) continue;
                Integer integer = map.get((long) nums[i]);
                if (integer == null) {
                    map.put(target - nums[i], i);
                } else {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(Math.min(nums[integer], nums[i]));
                    tmp.add(Math.max(nums[integer], nums[i]));
                    list.add(tmp);
                }
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (skip.contains(i)) continue;
                skip.add(i);
                int x = nums[i];
                List<List<Integer>> tmp = nSum(nums, target - x, n - 1, skip);
                tmp.forEach(e -> {
                    e.add(x);
                    e.sort(Integer::compareTo);
                    list.add(e);
                });
                skip.remove(i);
            }
        }
        return list.stream().distinct().collect(Collectors.toList());
    }
}
