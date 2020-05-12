package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class code5 {


    private Solution solution = new Solution();

    @Test
    public void test0() {
        String babad = solution.longestPalindrome("babad");
        Assert.assertEquals("bab", babad);
    }

    @Test
    public void test1() {
        String babad = solution.longestPalindrome("cbbd");
        Assert.assertEquals("bb", babad);
    }

    static class Solution {
        public String longestPalindrome(String s) {
            return "";
        }
    }
}
