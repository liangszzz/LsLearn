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
        int[] numbers = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (num != 0) {
            if (num >= numbers[i]) {
                builder.append(romans[i]);
                num -= numbers[i];
            } else {
                i++;
            }
        }
        return builder.toString();
    }
}
