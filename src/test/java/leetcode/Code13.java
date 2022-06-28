package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Code13 {

    @Test
    public void test() {
        Assertions.assertEquals(3, romanToInt("III"));
    }

    @Test
    public void test1() {
        Assertions.assertEquals(4, romanToInt("IV"));
    }

    @Test
    public void test2() {
        Assertions.assertEquals(9, romanToInt("IX"));
    }

    @Test
    public void test3() {
        Assertions.assertEquals(58, romanToInt("LVIII"));
    }

    @Test
    public void test4() {
        Assertions.assertEquals(1994, romanToInt("MCMXCIV"));
    }

    @Test
    public void test5() {
        Assertions.assertEquals(1476, romanToInt("MCDLXXVI"));
    }

    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; ) {
            char c1 = s.charAt(i);
            if (i >= 1) {
                char c2 = s.charAt(i - 1);
                Integer number = map.get(c2 + "" + c1);
                if (number != null) {
                    sum += number;
                    i -= 2;
                    continue;
                }
            }
            Integer number = map.get(c1 + "");
            sum += number;
            i -= 1;
        }
        return sum;
    }
}
