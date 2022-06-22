package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Common {

    public static ListNode numberToNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode tmp = head;
        for (int i = 1, len = arr.length; i < len; i++) {
            tmp.next = new ListNode(arr[i]);
            tmp = tmp.next;
        }
        return head;
    }

    public static int[] nodeToNumber(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Object[] objects = list.toArray();
        int[] arr = new int[objects.length];
        for (int i = 0; i < objects.length; i++) {
            arr[i] = (int) objects[i];
        }
        return arr;
    }
}
