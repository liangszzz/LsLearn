package leetcode;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code2 {


    @Test
    public void test0() {
        Solution solution = new Solution();
        ListNode listNode1 = buildNode(new int[]{2, 4, 3});
        ListNode listNode4 = buildNode(new int[]{5, 6, 4});
        ListNode listNode = solution.addTwoNumbers(listNode1, listNode4);
        Assertions.assertEquals(listNode, buildNode(new int[]{7, 0, 8}));
    }


    @Test
    public void test1() {
        Solution solution = new Solution();
        ListNode listNode1 = buildNode(new int[]{1, 8});
        ListNode listNode4 = buildNode(new int[]{0});
        ListNode listNode = solution.addTwoNumbers(listNode1, listNode4);
        Assertions.assertEquals(listNode, buildNode(new int[]{1, 8}));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        ListNode listNode1 = buildNode(new int[]{1, 2});
        ListNode listNode4 = buildNode(new int[]{2});
        ListNode listNode = solution.addTwoNumbers(listNode1, listNode4);
        Assertions.assertEquals(listNode, buildNode(new int[]{3, 2}));
    }

    @Test
    public void test3() {
        Solution solution = new Solution();
        ListNode listNode1 = buildNode(new int[]{1});
        ListNode listNode4 = buildNode(new int[]{9, 9});
        ListNode listNode = solution.addTwoNumbers(listNode1, listNode4);
        Assertions.assertEquals(listNode, buildNode(new int[]{0, 0, 1}));
    }

    @Test
    public void test4() {
        Solution solution = new Solution();
        ListNode listNode1 = buildNode(new int[]{8, 9, 9});
        ListNode listNode4 = buildNode(new int[]{2});
        ListNode listNode = solution.addTwoNumbers(listNode1, listNode4);
        Assertions.assertEquals(listNode, buildNode(new int[]{0, 0, 0, 1}));
    }


    private ListNode buildNode(int[] nodes) {
        ListNode head = new ListNode(nodes[0]);
        ListNode head2 = head;
        for (int i = 1; i < nodes.length; i++) {
            head2.next = new ListNode(nodes[i]);
            head2 = head2.next;
        }
        return head;
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            List<Integer> list = new ArrayList<>();
            ListNode l1_head = l1;
            ListNode l2_head = l2;
            int index = 0;
            ListNode head = new ListNode(0);
            ListNode head2 = head;
            do {
                int s1 = 0, s2 = 0;
                if (l1_head != null) {
                    s1 = l1_head.val;
                    l1_head = l1_head.next;
                }
                if (l2_head != null) {
                    s2 = l2_head.val;
                    l2_head = l2_head.next;
                }
                int s3 = s1 + s2;
                if (index == list.size())
                    list.add(0);
                int integer = list.get(index);
                if (s3 < 10) {
                    int sum = s3 + integer;
                    if (sum < 10) {
                        list.set(index, sum);
                    } else {
                        list.add(0);
                        list.set(index, sum - 10);
                        list.set(index + 1, 1);
                    }
                } else {
                    list.add(0);
                    list.set(index, s3 - 10 + integer);
                    list.set(index + 1, 1);
                }
                head2.next = new ListNode(list.get(index));
                head2 = head2.next;
                if (l1_head == null && l2_head == null) {
                    if (index + 1 == list.size()) break;
                    head2.next = new ListNode(list.get(index + 1));
                }
                index++;
            } while (l1_head != null || l2_head != null);
            return head.next;
        }
    }

    class Solution2 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            List<Integer> list = new ArrayList<>();

            ListNode l1_head = l1;
            ListNode l2_head = l2;
            int index = 0;
            boolean flag = true;
            do {
                int s1 = 0, s2 = 0;
                if (l1_head != null) {
                    s1 = l1_head.val;
                    l1_head = l1_head.next;
                }
                if (l2_head != null) {
                    s2 = l2_head.val;
                    l2_head = l2_head.next;
                }
                int s3 = s1 + s2;
                if (flag)
                    list.add(0);
                else flag = true;
                int integer = list.get(index);
                if (s3 < 10) {
                    int sum = s3 + integer;
                    if (sum < 10) {
                        list.set(index, sum);
                    } else {
                        list.set(index, sum - 10);
                        list.add(0);
                        flag = false;
                        list.set(index + 1, 1);
                    }
                } else {
                    list.set(index, s3 - 10 + integer);
                    list.add(0);
                    flag = false;
                    list.set(index + 1, 1);
                }
                index++;
            } while (l1_head != null || l2_head != null);


            ListNode head = new ListNode(list.get(0));
            ListNode head2 = head;
            for (int i = 1; i < list.size(); i++) {
                if (i == list.size() - 1 && list.get(i) == 0) {
                    break;
                }
                head2.next = new ListNode(list.get(i));
                head2 = head2.next;
            }
            return head;
        }
    }

    class Solution1 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();

            ListNode l1_head = l1;
            ListNode l2_head = l2;

            do {
                if (l1_head != null) {
                    list1.add(l1_head.val);
                    l1_head = l1_head.next;
                } else {
                    list1.add(0);
                }
                if (l2_head != null) {
                    list2.add(l2_head.val);
                    l2_head = l2_head.next;
                } else {
                    list2.add(0);
                }
            } while (l1_head != null || l2_head != null);

            int[] list = new int[list1.size() + 1];
            Arrays.fill(list, 0);

            for (int i = 0; i < list1.size(); i++) {
                int s1 = list1.get(i), s2 = list2.get(i);
                int s3 = s1 + s2;
                int integer = list[i];
                if (s3 < 10) {
                    int sum = s3 + integer;
                    if (sum < 10) {
                        list[i] = sum;
                    } else {
                        list[i] = sum - 10;
                        list[i + 1] = 1;
                    }
                } else {
                    list[i] = s3 - 10 + integer;
                    list[i + 1] = 1;
                }
            }
            ListNode head = new ListNode(list[0]);
            ListNode head2 = head;
            for (int i = 1; i < list.length; i++) {
                if (i == list.length - 1 && list[i] == 0) {
                    break;
                }
                head2.next = new ListNode(list[i]);
                head2 = head2.next;
            }
            return head;
        }
    }


    @ToString
    @EqualsAndHashCode
    class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }
}
