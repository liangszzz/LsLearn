package book1;

import org.junit.Test;

import java.util.Arrays;

public class book5_6 {


    @Test
    public void test0() {
        int[] array=new int[]{1,2,3,4,5,6,7,10,9,9,3,2,3};
        System.out.println(getMax(array));
    }

    public int getMax(int[] i) {

        switch (i.length) {
            case 0:
                return 0;
            case 1:
                return i[0];
            case 2:
                return i[0] > i[1] ? i[0] : i[1];
            default:
                int left = i.length / 2;
                int x1 = getMax(Arrays.copyOfRange(i, 0, left));
                int x2 = getMax(Arrays.copyOfRange(i, left + 1, i.length));
                return x1 > x2 ? x1 : x2;
        }
    }

}
