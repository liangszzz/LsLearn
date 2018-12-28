package lintcode;

import org.junit.Test;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的距离。
 */
public class maxDepth {

    @Test
    public void test0() {
        System.out.println(maxDepth(TreeNode.getNode()));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
