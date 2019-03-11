package code;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 两数相加
 * leetcode2
 */
public class leetcode2 implements Test0 {

    @Test
    @Override
    public void test0() {

//        ListNode node = new ListNode(1);
//
//        ListNode node2 = new ListNode(9);
//        ListNode node3 = new ListNode(9);
//        ListNode node4 = new ListNode(9);
//        ListNode node5 = new ListNode(9);
//        ListNode node6 = new ListNode(9);
//        ListNode node7 = new ListNode(9);
//        ListNode node8 = new ListNode(9);
//        ListNode node9 = new ListNode(9);
//        ListNode node10 = new ListNode(9);
//
//
//        node.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;
//        node7.next = node8;
//        node8.next = node9;
//        node9.next = node10;

        ListNode l11=new ListNode(2);
        ListNode l12=new ListNode(4);
        ListNode l13=new ListNode(3);

        l11.next=l12;
        l12.next=l13;

        ListNode l21=new ListNode(5);
        ListNode l22=new ListNode(6);
        ListNode l23=new ListNode(4);
        l21.next=l22;
        l22.next=l23;

        System.out.println(addTwoNumbers(l11,l21));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        List<Integer> listNodes = new ArrayList<>();
        while (l1 != null) {
            listNodes.add(l1.val);
            l1 = l1.next;
        }

        List<Integer> listNodes2 = new ArrayList<>();
        while (l2 != null) {
            listNodes2.add(l2.val);
            l2 = l2.next;
        }

        if (listNodes.size() > listNodes2.size()) {
            return getNodes(listNodes, listNodes2);
        } else {
            return getNodes(listNodes2, listNodes);
        }
    }

    ListNode getNodes(List<Integer> l1, List<Integer> l2) {
        for (int i = l2.size(); i < l1.size(); i++) {
            l2.add(0);
        }
        l1.add(0);
        l2.add(0);
        ListNode node = new ListNode(-1);
        ListNode head = node;
        for (int i = 0; i < l1.size(); i++) {
            int a = l1.get(i);
            int b = l2.get(i);
            if (a + b >= 10) {
                l1.set(i + 1, l1.get(i + 1) + 1);
            }
            if (i == l1.size()-1 && a + b == 0) break;
            ListNode listNode = new ListNode((a + b) % 10);
            head.next = listNode;
            head = listNode;

        }
        return node.next;
    }

}
