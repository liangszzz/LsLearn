package algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 快排
 *
 * @author admin
 */
public class QuickSort {

    @Test
    public void test0() {
        List<Integer> list = getList();
        for (int i : list) {
            System.out.print(i + ",");
        }
        System.out.println("");
        quickSort(list, 0, list.size() - 1);
        for (int i : list) {
            System.out.print(i + ",");
        }
    }


    public void quickSort(List<Integer> list, int start, int end) {

        if (end < start) {
            return;
        }

        //以第一位为基准,排序
        int base = list.get(start);
        int i = start, j = end;

        while (i != j) {

            //先右哨兵向左寻找 小于 base 的数,找到停下
            while (list.get(j) >= base && i < j) {
                j--;
            }

            //再左哨兵向右寻找 大于 base 的数,找到停下
            while (list.get(i) <= base && i < j) {
                i++;
            }

            //哨兵没有相遇  交换 i,j
            if (i < j) {
                int temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }
        //两哨兵相遇,交换基准数 与 相遇的数
        int temp = list.get(i);
        list.set(i, base);
        list.set(start, temp);

        quickSort(list, start, i - 1);
        quickSort(list, i + 1, end);
    }


    private List<Integer> getList() {
        List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(1);
        list.add(2);
        list.add(7);
        list.add(9);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(10);
        list.add(8);
        return list;
    }

}
