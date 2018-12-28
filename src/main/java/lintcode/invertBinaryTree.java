package lintcode;

import org.junit.Test;

import java.util.LinkedList;

/**
 * 翻转一棵二叉树
 */
public class invertBinaryTree {

    @Test
    public void test0() {
        invertBinaryTree(TreeNode.getNode());
    }

    @Test
    public void test1() {
//        invertBinaryTree2(TreeNode.getNode());

        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(3);
        treeNode.right = treeNode2;
        invertBinaryTree2(treeNode);
        System.out.println(treeNode);
    }


    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        if (root != null) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            invertBinaryTree(root.left);
            invertBinaryTree(root.right);
        }
    }

    public void invertBinaryTree2(TreeNode root) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.offer(root);
        while (!linkedList.isEmpty()) {
            TreeNode node = linkedList.poll();
            if (node != null) {
                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;

                linkedList.offer(node.left);
                linkedList.offer(node.right);
            }

        }
    }
}
