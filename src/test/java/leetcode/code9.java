package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class code9 {

    Solution solution = new Solution();

    @Test
    public void t0() {
        boolean palindrome = solution.isPalindrome(121);
        Assertions.assertTrue(palindrome);
    }

    static class Solution {
        public boolean isPalindrome(int x) {
            String str = x + "";
            for (int i = 0, len = str.length(); i < len; i++) {
                if (str.charAt(i) != str.charAt(len - i - 1))
                    return false;
            }
            return true;
        }
    }
}


