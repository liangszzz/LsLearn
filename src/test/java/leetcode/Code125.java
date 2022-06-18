package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Code125 {

    @Test
    public void test() {
        Assertions.assertTrue(isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    public void test1() {
        Assertions.assertFalse(isPalindrome("race a car"));
    }

    @Test
    public void test2() {
        Assertions.assertTrue(isPalindrome(".,"));
    }

    @Test
    public void test3() {
        Assertions.assertFalse(isPalindrome("1a2"));
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return true;
        }
        s = s.toLowerCase();
        int len = s.length();
        for (int i = 0, j = len - 1; i <= j; ) {
            char l = s.charAt(i);
            char r = s.charAt(j);

            boolean ltrue = isNumOrChar(l);
            boolean rtrue = isNumOrChar(r);

            if (ltrue && rtrue) {
                if (l != r) {
                    return false;
                }
            }
            if ((ltrue && rtrue) || (!ltrue && !rtrue)) {
                i++;
                j--;
            } else {
                if (!ltrue) {
                    i++;
                }
                if (!rtrue) {
                    j--;
                }
            }

        }
        return true;
    }

    private boolean isNumOrChar(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        }

        if (c >= '0' && c <= '9') {
            return true;
        }

        return false;
    }
}
