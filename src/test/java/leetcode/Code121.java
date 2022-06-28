package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Code121 {

    @Test
    public void test() {
        Assertions.assertEquals(5, maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    @Test
    public void test1() {
        Assertions.assertEquals(0, maxProfit(new int[]{7, 6, 4, 3, 1}));
    }


    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int max = 0;
        // min number before today
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            // today's max profit
            int a = prices[i] - min;

            if (a > max) {
                max = a;
            }
            if (a < 0) {
                min = prices[i];
            }
        }
        return max;
    }

    /**
     * 暴力法
     */
    public int maxProfit2(int[] prices) {
        int max = 0;
        int min = -1;
        // 从后开始找
        for (int i = prices.length - 1; i >= 0; i--) {
            int price = prices[i];
            // 找比价格小的数的下标
            if (min == -1) {
                min = findMin(prices, i, price);
            }
            if (min != -1) {
                if (i == min) {
                    // 表示这个就是后面的最小值
                    min = -1;
                } else {
                    int s = price - prices[min];
                    if (s > max) {
                        max = s;
                    }
                }
            }
        }
        return max;
    }

    private int findMin(int[] prices, int index, int currPrice) {
        long min = Long.MAX_VALUE;
        int k = -1;
        for (int i = 0; i < index; i++) {
            int a = prices[i];
            if (a < currPrice && a < min) {
                min = a;
                k = i;
            }
        }
        return k;
    }
}
