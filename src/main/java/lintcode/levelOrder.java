package lintcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 层次遍历：只需按层次遍历即可
 */
public class levelOrder {

    @Test
    public void test0() {
        System.out.println(levelOrder(TreeNode.getNode()));
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root != null) {

            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                List<Integer> list1 = new ArrayList<>();
                List<TreeNode> nodes = new ArrayList<>();
                while (!queue.isEmpty()) {
                    TreeNode node = queue.poll();
                    list1.add(node.val);
                    nodes.add(node);
                }
                list.add(list1);

                for (TreeNode node:nodes){
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
        }
        return list;
    }
}
