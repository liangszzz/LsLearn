package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class Code278 {

    @Test
    public void test() {
        Assertions.assertEquals(4, firstBadVersion(5));
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        int firstTrue = Integer.MAX_VALUE;
        while (left <= right) {
            int x = left + (right - left) / 2;

            if (isBadVersion(x)) {
                if (x < firstTrue)
                    firstTrue = x;
                else
                    return firstTrue;
                right = right == x ? right - 1 : x;
            } else {
                left = left == x ? left + 1 : x;
            }
        }
        return firstTrue;
    }


    boolean isBadVersion(int version) {
        switch (version) {
            case 1:
            case 2:
            case 3:
                return false;
            case 4:
            case 5:
                return true;
            default:

        }
        return false;
    }
}
