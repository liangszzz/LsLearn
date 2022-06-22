package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Code799 {

    @Test
    public void test0() {
        Assertions.assertEquals(0, champagneTower(1, 1, 1));
    }

    @Test
    public void test1() {
        Assertions.assertEquals(0.5, champagneTower(2, 1, 1));
    }

    @Test
    public void test2() {
        Assertions.assertEquals(1, champagneTower(100000009, 33, 17));
    }

    @Test
    public void test3() {
        Assertions.assertEquals(0.1875, champagneTower2(25, 6, 1));
        Assertions.assertEquals(0.1875, champagneTower(25, 6, 1));
    }

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] arr = new double[100][100];
        arr[0][0] = poured;
        for (int i = 1; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    arr[i][j] = Math.max(0, (arr[i - 1][j] - 1) / 2.0);
                } else if (j == i) {
                    arr[i][j] = Math.max(0, (arr[i - 1][j - 1] - 1) / 2.0);
                } else {
                    arr[i][j] = Math.max(0, (arr[i - 1][j] - 1) / 2.0) + Math.max(0, (arr[i - 1][j - 1] - 1) / 2.0);
                }
            }
        }
        double v = arr[query_row][query_glass];
        if (v >= 1) return 1;
        if (v <= 0) return 0;
        return v;
    }

    public double champagneTower2(int poured, int query_row, int query_glass) {
        double[][] A = new double[102][102];
        A[0][0] = (double) poured;
        for (int r = 0; r <= query_row; ++r) {
            for (int c = 0; c <= r; ++c) {
                double q = (A[r][c] - 1.0) / 2.0;
                if (q > 0) {
                    A[r + 1][c] += q;
                    A[r + 1][c + 1] += q;
                }
            }
        }

        return Math.min(1, A[query_row][query_glass]);
    }
}
