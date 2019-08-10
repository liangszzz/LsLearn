package code;

import org.junit.Test;

/**
 * 设计一个算法，计算出n阶乘中尾部零的个数
 */
public class trailingZeros {

    @Test
    public void test0() {
        System.out.println(trailingZeros(1001171717));
        System.out.println(trailingZeros2(1001171717));
    }

    public long trailingZeros(long n) {
        int count = 0;

        for (int i = 5; i <= n; i += 5) {
            int m = i;
            while (m % 5 == 0) {
                count++;
                m = m / 5;
            }
        }
        return count;
    }

    public long trailingZeros2(long n) {
        long count = 0;
        long temp = n / 5;
        while (temp != 0) {
            count += temp;
            temp /= 5;
        }
        return count;
    }

}
