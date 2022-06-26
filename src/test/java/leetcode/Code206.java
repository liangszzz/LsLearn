package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class Code206 {

    @Test
    public void test() {
        ListNode node = Common.numberToNode(new int[]{1, 2, 3, 4, 5});
        Assertions.assertArrayEquals(new int[]{5, 4, 3, 2, 1}, Common.nodeToNumber(reverseList(node)));
    }


    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        List<ListNode> nodes = new LinkedList<>();

        ListNode h = head;
        while (h != null) {
            nodes.add(h);
            h = h.next;
        }
        ListNode node = new ListNode(0);
        ListNode h2 = node;
        for (int i = nodes.size() - 1; i >= 0; i--) {
            ListNode node1 = nodes.get(i);
            if (i == 0) {
                node1.next = null;
            }
            h2.next = node1;
            h2 = h2.next;
        }
        return node.next;
    }
}
