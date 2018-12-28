package lintcode;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给出一棵二叉树，返回其节点值的前序遍历。
 */
public class preorderTraversal {

    /**
     * 前序遍历：根结点 ---> 左子树 ---> 右子树
     * 递归
     */
    @Test
    public void test0() {
        System.out.println(preorderTraversal(TreeNode.getNode()));
    }

    /**
     * 前序遍历：根结点 ---> 左子树 ---> 右子树
     * 非递归
     */
    @Test
    public void test1() {
        System.out.println(preorderTraversal2(TreeNode.getNode()));
    }


    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        if (root != null) {
            tre(root, list);
        }
        return list;
    }

    public void tre(TreeNode node, List<Integer> list) {
        list.add(node.val);
        if (node.left != null) {
            tre(node.left, list);
        }
        if (node.right != null) {
            tre(node.right, list);
        }

    }

    public List<Integer> preorderTraversal2(TreeNode root) {

        List<Integer> list = new ArrayList<>();


        if (root != null) {

            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while (!stack.empty()) {

                TreeNode pop = stack.pop();
                list.add(pop.val);

                if (pop.right != null) {
                    stack.push(pop.right);
                }

                if (pop.left != null) {
                    stack.push(pop.left);
                }
            }

        }

        return list;
    }

}
