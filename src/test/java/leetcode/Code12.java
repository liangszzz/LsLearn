package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Code12 {

    @Test
    public void test1() {
        Assertions.assertEquals("III", intToRoman(3));
    }

    @Test
    public void test2() {
        Assertions.assertEquals("IV", intToRoman(4));
    }


    @Test
    public void test3() {
        Assertions.assertEquals("IX", intToRoman(9));
    }


    @Test
    public void test4() {
        Assertions.assertEquals("LVIII", intToRoman(58));
    }


    @Test
    public void test5() {
        Assertions.assertEquals("MCMXCIV", intToRoman(1994));
    }

    public String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");

        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");
        StringBuilder builder = new StringBuilder();
        String snum = num + "";
        for (int i = snum.length() - 1; i >= 0; i--) {
            int x = Integer.parseInt(snum.charAt(i) + "");

        }
        return builder.toString();

    }
}
