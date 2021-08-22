package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code6 {

    private final Code6.Solution solution = new Code6.Solution();

    @Test
    public void test() {
        String test = solution.convert("A", 1);
        Assertions.assertEquals("A", test);
    }

    @Test
    public void test0() {
        String test = solution.convert("LEETCODEISHIRING", 3);
        Assertions.assertEquals("LCIRETOESIIGEDHN", test);
    }

    @Test
    public void test1() {
        String test = solution.convert("LEETCODEISHIRING", 4);
        Assertions.assertEquals("LDREOEIIECIHNTSG", test);
    }

    @Test
    public void test2() {
        String test = solution.convert("AB", 1);
        Assertions.assertEquals("AB", test);
    }

    static class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1) {
                return s;
            }
            String[][] strs = new String[s.length()][numRows];
            int index = 0;
            int last_x = 0;
            int last_y = 0;
            for (int i = 0; i < strs.length; i++) {
                for (int j = 0; j < numRows; j++) {
                    if (index >= s.length()) {
                        break;
                    }
                    if (i % (numRows - 1) == 0) {
                        strs[i][j] = s.substring(index, index + 1);
                        last_x = i;
                        last_y = j;
                        index++;
                    } else {
                        strs[++last_x][--last_y] = s.substring(index, index + 1);
                        i = last_x;
                        j = last_y;
                        index++;
                    }
                }
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < numRows; i++) {
                for (String[] str : strs) {
                    builder.append(str[i] != null ? str[i] : "");
                }
            }

            return builder.toString();
        }
    }
}
