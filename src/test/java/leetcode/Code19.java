package leetcode;

import org.junit.jupiter.api.Test;

public class Code19 {

    @Test
    public void test() {
        ListNode node = Common.numberToNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(removeNthFromEnd(node, 2));
    }

    @Test
    public void test1() {
        ListNode node = Common.numberToNode(new int[]{1});
        System.out.println(removeNthFromEnd(node, 1));
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode before = new ListNode();
        before.next = head;
        ListNode fast = before, slow = before;

        while (fast != null) {
            if (n >= 0) {
                fast = fast.next;
                n--;
            } else {
                fast = fast.next;
                slow = slow.next;
            }
        }
        slow.next = slow.next.next;
        return before.next;
    }
}
