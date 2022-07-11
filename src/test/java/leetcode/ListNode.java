package leetcode;

import lombok.ToString;

@ToString
public class ListNode {

    int val;

    ListNode next;

    ListNode() {}

    ListNode(int x) {
        val = x;
        next = null;
    }
}
