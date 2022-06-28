package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Code409 {

    @Test
    public void test() {
        Assertions.assertEquals(7, longestPalindrome("abccccdd"));
    }

    @Test
    public void test1() {
        Assertions.assertEquals(1, longestPalindrome("a"));
    }

    @Test
    public void test2() {
        Assertions.assertEquals(2, longestPalindrome("bb"));
    }

    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, len = s.length(); i < len; i++) {
            char c = s.charAt(i);
            map.merge(c, 1, Integer::sum);
        }
        AtomicInteger sum = new AtomicInteger();
        // if value has x%2==1 flag=1
        AtomicInteger flag = new AtomicInteger();
        map.keySet().forEach(e -> {
            Integer x = map.get(e);
            if (x % 2 == 1) {
                flag.set(1);
            }
            sum.set(sum.get() + (x / 2) * 2);
        });
        return sum.get() + flag.get();
    }
}
