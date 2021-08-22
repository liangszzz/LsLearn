package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code3 {

    private Solution solution= new Solution();


    @Test
    public void test0() {
        int val = solution.lengthOfLongestSubstring("abcabcbb");
        Assertions.assertEquals(3, val);
    }

    @Test
    public void test1() {
        int val = solution.lengthOfLongestSubstring("bbbbb");
        Assertions.assertEquals(1, val);
    }

    @Test
    public void test2() {
        int val = solution.lengthOfLongestSubstring("pwwkew");
        Assertions.assertEquals(3, val);
    }

    @Test
    public void test3() {
        int val = solution.lengthOfLongestSubstring("dvdf");
        Assertions.assertEquals(3, val);
    }

    @Test
    public void test4() {
        int val = solution.lengthOfLongestSubstring("asjrgapa");
        Assertions.assertEquals(6, val);
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int len = s.length();
            if (len == 1) return 1;
            int max = 0;

            int index = 1;

            Set<Character> set = new HashSet<>();
            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                if (set.contains(c)) {
                    if (max < set.size())
                        max = set.size();
                    set.clear();
                    i = index - 1;
                    index++;
                    continue;
                }
                set.add(c);
                if (i == len - 1 && max < set.size()) {
                    max = set.size();
                }
            }
            return max;
        }
    }
}
