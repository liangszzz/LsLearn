package leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Code142 {

    @Test
    public void test() {


    }

    public ListNode detectCycle(ListNode head) {

        Map<Integer, ListNode> map = new HashMap<>();

        while (head != null) {
            ListNode node = map.get(head.hashCode());
            if (node != null) {
                return node;
            }
            map.put(head.hashCode(), head);
            head = head.next;
        }
        return null;
    }
}
