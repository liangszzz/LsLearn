package lintcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 反转一个只有3位数的整数。
 */
public class reverseInteger {

    @Test
    public void test0() {
        System.out.println(reverseInteger(120));
    }

    /**
     * @param number: A 3-digit number.
     * @return: Reversed number.
     */
    public int reverseInteger(int number) {
        String str = number + "";
        String str2 = "";
        for (int i = str.length()-1; i >= 0; i--) {
            str2 = str2 + str.charAt(i);
        }
        return Integer.parseInt(str2);
    }
}
