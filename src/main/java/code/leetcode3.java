package code;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class leetcode3 implements Test0 {

    @Test
    @Override
    public void test0() {
        System.out.println(lengthOfLongestSubstring("abccc"));
    }

    public int lengthOfLongestSubstring(String s) {
        int maxCount = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                if (set.add(s.charAt(i + j))) {
                    if (maxCount < set.size()) {
                        maxCount = set.size();
                    }
                } else {
                    set.clear();
                    break;
                }
            }
        }
        return maxCount;
    }
}
