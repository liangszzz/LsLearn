package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class Code202 {

    @Test
    void test0() {
        Assertions.assertTrue(isHappy(19));
    }

    @Test
    void test1() {
        Assertions.assertFalse(isHappy(5));
    }

    public boolean isHappy(int n) {
        String str = n + "";
        Set<Integer> set = new HashSet<>();
        while (true) {
            int num = 0;
            for (int i = 0; i < str.length(); i++) {
                int k = Integer.parseInt(str.charAt(i) + "");
                num += k * k;
            }
            if (set.contains(num)) {
                return false;
            }
            set.add(num);
            if (num == 1) {
                return true;
            }
            str = num + "";
        }
    }
}
