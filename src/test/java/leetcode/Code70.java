package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Code70 {

    @Test
    void test() {
        Assertions.assertEquals(2, climbStairs(2));
        Assertions.assertEquals(3, climbStairs(3));
    }

    @Test
    void test1() {
        Assertions.assertEquals(5, climbStairs(4));
        Assertions.assertEquals(1836311903, climbStairs(45));
    }

    public int climbStairs(int n) {
        int[] dp = new int[46];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    Map<Integer, Integer> map = new HashMap<>();

    public int climbStairs_bak(int n) {
        Integer integer = map.get(n);
        if (integer != null) {
            return integer;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int v = climbStairs(n - 1) + climbStairs(n - 2);
        map.put(n, v);
        return v;
    }
}
