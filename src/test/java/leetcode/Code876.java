package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Code876 {

    @Test
    public void test0() {
        ListNode node = Common.numberToNode(new int[]{1, 2, 3, 4, 5});
        Assertions.assertEquals(3, middleNode(node).val);
    }

    @Test
    public void test1() {
        ListNode node = Common.numberToNode(new int[]{1, 2, 3, 4, 5, 6});
        Assertions.assertEquals(4, middleNode(node).val);
    }


    public ListNode middleNode(ListNode head) {
        List<ListNode> nodeList = new ArrayList<>(100);
        while (head != null) {
            nodeList.add(head);
            head = head.next;
        }
        int size = nodeList.size();
        return nodeList.get(size % 2 == 0 ? size / 2 : (size - 1) / 2);
    }
}
