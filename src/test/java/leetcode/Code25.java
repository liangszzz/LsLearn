package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Code25 {

    @Test
    public void test() {

        ListNode node = Common.numberToNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(reverseKGroup(node, 2));
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) return head;
        ListNode before = new ListNode();
        before.next = head;
        ListNode group = null;
        ListNode result = before;
        ListNode tmp = head;
        int count = 0;

        while (tmp != null) {
            if (count == 0) {
                group = tmp;
            } else if (count == k - 1) {
                count = 0;
                ListNode next = tmp.next;
                tmp.next = null;
                before.next = reverseNode(group, next);
                for (int i = 0; i < k; i++) {
                    before = before.next;
                }
                tmp = next;
                continue;
            }
            tmp = tmp.next;
            count++;
        }

        return result.next;
    }

    public ListNode reverseNode(ListNode head, ListNode next) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        ListNode before = new ListNode();
        ListNode result = before;
        for (int i = list.size() - 1; i >= 0; i--) {
            before.next = list.get(i);
            before = before.next;
        }
        before.next = next;
        return result.next;

    }
}
