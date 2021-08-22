package leetcode;

import org.apache.poi.ss.usermodel.CellStyle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * <p>
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 * <p>
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 * <p>
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 * <p>
 * 提示：
 * <p>
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 * <p>
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 * <p>
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 * <p>
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * 示例 5:
 * <p>
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code8 {

    Solution solution = new Solution();

    @Test
    public void test0() {
        int i = solution.myAtoi("42");
        Assertions.assertEquals(42, i);
    }

    @Test
    public void test1() {
        int i = solution.myAtoi("    -42");
        Assertions.assertEquals(-42, i);
    }

    @Test
    public void test2() {
        int i = solution.myAtoi("4193 with");
        Assertions.assertEquals(4193, i);
    }

    @Test
    public void test3() {
        int i = solution.myAtoi("word 4193 with");
        Assertions.assertEquals(0, i);
    }

    @Test
    public void test4() {
        int i = solution.myAtoi("-91283472332");
        Assertions.assertEquals(-2147483648, i);
    }

    @Test
    public void test5() {
        int i = solution.myAtoi("3.14");
        Assertions.assertEquals(3, i);
    }

    @Test
    public void test6() {
        int i = solution.myAtoi("");
        Assertions.assertEquals(0, i);
    }

    @Test
    public void test7() {
        int i = solution.myAtoi("-");
        Assertions.assertEquals(0, i);
    }

    @Test
    public void test8() {
        int i = solution.myAtoi("+");
        Assertions.assertEquals(0, i);
    }

    @Test
    public void test9() {
        int i = solution.myAtoi(" 0000000000012345678");
        Assertions.assertEquals(12345678, i);
    }

    @Test
    public void test10() {
        int i = solution.myAtoi("+-2");
        Assertions.assertEquals(0, i);
    }

    @Test
    public void test11() {
        int i = solution.myAtoi("20000000000000000000");
        Assertions.assertEquals(Integer.MAX_VALUE, i);
    }

    @Test
    public void test12() {
        int i = solution.myAtoi(" 00 ");
        Assertions.assertEquals(0, i);
    }

    @Test
    public void test13() {
        int i = solution.myAtoi("    +11191657170");
        Assertions.assertEquals(2147483647, i);
    }

    static class Solution {
        public int myAtoi(String str) {
            String trim = str.trim();
            if (trim.length() == 0 || "-".equals(str) || "+".equals(str)) {
                return 0;
            }
            char c = trim.charAt(0);
            if (c == '-' || c == '+') {
                long l = Long.parseLong(c + index(trim.substring(1)));
                if (l < 0)
                    return l < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int) l;
                else return l > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) l;
            } else if (c >= '0' && c <= '9') {
                long l = Long.parseLong(index(trim));
                return l > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) l;
            }
            return 0;
        }

        private String index(String str) {
            if (str.startsWith("0")) {
                return index(str.substring(1));
            }
            String sub = str;
            for (int i = 0; i < str.length(); i++) {
                if (!Character.isDigit(str.charAt(i))) {
                    sub = str.substring(0, i);
                    break;
                }
            }
            if (sub.length() > 13) {
                sub = sub.substring(0, 14);
            }
            if (sub.length() == 0) return "0";
            return sub;
        }

    }
}
