package leetcode;

import org.junit.jupiter.api.Test;

public class Code24 {

    @Test
    public void test(){
        ListNode node = Common.numberToNode(new int[]{1, 2, 3, 4});
        System.out.println(swapPairs(node));
    }

    public ListNode swapPairs(ListNode head) {
        ListNode beforeNode = new ListNode();
        beforeNode.next = head;
        ListNode result = beforeNode;
        ListNode tmp = head;
        while(tmp != null && tmp.next != null){
            ListNode t1 = tmp;
            ListNode t2 = tmp.next;
            // 交换
            beforeNode.next = t2;
            ListNode temp = t2.next;
            t2.next = t1;
            t1.next = temp;
            // 下一步
            tmp = temp;
            beforeNode = beforeNode.next.next;
        }
        return result.next;
    }
}
