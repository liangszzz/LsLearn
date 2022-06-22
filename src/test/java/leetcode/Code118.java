package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Code118 {

    @Test
    public void test() {
        List<List<Integer>> generate = generate(5);
        System.out.println(generate);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> z0 = new ArrayList<>();
        z0.add(1);
        list.add(z0);

        for (int i = 1; i < numRows; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {

                if (j == 0 || i == j) {
                    tmp.add(1);
                } else {
                    int num = list.get(i - 1).get(j) + list.get(i - 1).get(j - 1);
                    tmp.add(num);
                }
            }
            list.add(tmp);
        }
        return list;
    }
}
