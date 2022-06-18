package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Code141 {

    @Test
    public void test() {
        ListNode node = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        Assertions.assertTrue(hasCycle(node));
    }

    @Test
    public void test1() {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        node.next = node1;
        node1.next = node;
        Assertions.assertTrue(hasCycle(node));
    }

    @Test
    public void test2() {
        ListNode node = new ListNode(1);
        Assertions.assertFalse(hasCycle(node));
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode hurry = head;
        while (hurry != null && hurry.next != null) {
            slow = slow.next;
            hurry = hurry.next.next;

            if (slow == hurry) {
                return true;
            }
        }
        return false;
    }
}
