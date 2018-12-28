package lintcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class inorderTraversal {

    /**
     * 中序遍历：左子树---> 根结点 ---> 右子树
     * 递归
     */
    @Test
    public void test0() {
        System.out.println(inorderTraversal(TreeNode.getNode()));
    }

    /**
     * 中序遍历：左子树---> 根结点 ---> 右子树
     * 非递归
     */
    @Test
    public void test1() {

        System.out.println(inorderTraversal2(TreeNode.getNode()));
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        if (root != null) {
            tre(root, list);
        }
        return list;
    }

    private void tre(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            tre(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            tre(root.right, list);
        }
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            TreeNode current = root;
            while (root != null) {

            }

        }
        return list;
    }
}
