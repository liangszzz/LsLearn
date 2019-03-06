package code;

import org.junit.Test;

public class countNodes {


    @Test
    public void test0() {

        countNodes(null);
    }


    public int countNodes(ListNode head) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            count++;
        }
        return count;
    }
}
