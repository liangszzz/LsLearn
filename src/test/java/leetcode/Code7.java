package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * <p>
 * 通过次数461,863提交次数1,332,007
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code7 {

    Solution solution = new Solution();

    @Test
    public void test0() {
        int reverse = solution.reverse(123);
        Assertions.assertEquals(321, reverse);
    }

    @Test
    public void test1() {
        int reverse = solution.reverse(-123);
        Assertions.assertEquals(-321, reverse);
    }

    @Test
    public void test2() {
        int reverse = solution.reverse(120);
        Assertions.assertEquals(21, reverse);
    }

    @Test
    public void test3() {
        int reverse = solution.reverse(1534236469);
//        Assertions.assertEquals(9646324351, reverse);
    }

    static class Solution {
        public int reverse(int x) {
            boolean flag = true;
            char[] strs;
            if (x < 0) {
                flag = false;
                strs = (x + "").substring(1).toCharArray();
            } else {
                strs = (x + "").toCharArray();
            }

            int len = strs.length % 2 == 0 ? strs.length / 2 : (strs.length + 1) / 2;
            for (int i = 0; i < len; i++) {
                char tmp = strs[i];
                strs[i] = strs[strs.length - i - 1];
                strs[strs.length - i - 1] = tmp;
            }
            String str = new String(strs);
            long i = Long.parseLong(str);
            if (i > Integer.MAX_VALUE || -1 * i < Integer.MIN_VALUE) return 0;
            return flag ? (int) i : (int) i * -1;
        }
    }
}
