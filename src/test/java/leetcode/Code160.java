package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class Code160 {


    @Test
    void test1() {
        ListNode headA = new ListNode(4);
        ListNode headB = new ListNode(5);

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(1);

        headA.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        headB.next = node5;
        node5.next = node6;
        node6.next = node2;

        ListNode node = getIntersectionNode(headA, headB);
        Assertions.assertEquals(8, node.val);
    }

    @Test
    void test2() {
        ListNode headA = new ListNode(1);
        ListNode headB = new ListNode(3);

        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(4);

        headA.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        headB.next = node3;

        Assertions.assertEquals(2, getIntersectionNode(headA, headB).val);
    }

    @Test
    void test3() {
        ListNode headA = new ListNode(2);
        ListNode headB = new ListNode(1);

        ListNode node1 = new ListNode(6);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);

        headA.next = node1;
        node1.next = node2;
        headB.next = node3;

        Assertions.assertNull(getIntersectionNode(headA, headB));
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        int countA = 0;
        while (headA != null) {
            countA++;
            headA = headA.next;
        }

        int countB = 0;
        while (headB != null) {
            countB++;
            headB = headB.next;
        }

        while (a != null && b != null) {

            if (a == b) {
                return a;
            }

            int steps = countA - countB;
            if (steps > 0) {
                for (int i = 0; i < steps; i++) {
                    a = a.next;
                    countA--;
                }
            } else if (steps < 0) {
                for (int i = 0; i < steps * -1; i++) {
                    b = b.next;
                    countB--;
                }
            } else {
                a = a.next;
                b = b.next;
            }
        }
        return null;
    }


    public ListNode getIntersectionNode_bak(ListNode headA, ListNode headB) {
        Map<Integer, ListNode> mapA = new HashMap<>();
        while (headA != null) {
            mapA.put(headA.hashCode(), headA);
            headA = headA.next;
        }

        while (headB != null) {
            ListNode node = mapA.get(headB.hashCode());
            if (node != null) {
                return node;
            }
            headB = headB.next;
        }
        return null;
    }
}
