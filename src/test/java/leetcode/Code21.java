package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Code21 {

    @Test
    public void test() {
        ListNode l1 = Common.numberToNode(new int[]{1, 2, 4});
        ListNode l2 = Common.numberToNode(new int[]{1, 3, 4});
        int[] ints = {1, 1, 2, 3, 4, 4};
        ListNode node = mergeTwoLists(l1, l2);
        Assertions.assertEquals(ints, Common.nodeToNumber(node));
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                int v1 = list1.val;
                int v2 = list2.val;
                if (v1 < v2) {
                    tmp.next = new ListNode(v1);
                    list1 = list1.next;
                } else {
                    tmp.next = new ListNode(v2);
                    list2 = list2.next;
                }
            }
            else if (list1 != null) {
                tmp.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                tmp.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            tmp = tmp.next;
        }
        return head.next;
    }
}
