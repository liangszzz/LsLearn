package leetcode;

public class Code23 {

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null) {
            return null;
        }
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode node = lists[0];
        for (int i = 0, len = lists.length; i < len - 1; i++) {
            node = mergeTwoLists(node, lists[i + 1]);
        }
        return node;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode temp = node;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                temp.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                int v1 = l1.val;
                int v2 = l2.val;
                if (v1 > v2) {
                    temp.next = l2;
                    l2 = l2.next;
                } else {
                    temp.next = l1;
                    l1 = l1.next;
                }
            }
            temp = temp.next;
        }
        return node.next;
    }
}
