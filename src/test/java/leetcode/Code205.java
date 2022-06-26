package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Code205 {

    @Test
    public void test() {
        Assertions.assertTrue(isIsomorphic("egg", "add"));
    }

    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        int len1 = s.length();
        int len2 = t.length();
        if (len1 != len2) {
            return false;
        }
        int[] tran = tran(s);
        int[] tran1 = tran(t);
        return Arrays.equals(tran, tran1);
    }

    public int[] tran(String s) {
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int i1 = s.indexOf(s.charAt(i) + "");
            if (i1 == -1) {
                arr[i] = i;
            } else {
                arr[i] = i1;
            }
        }
        return arr;
    }
}
