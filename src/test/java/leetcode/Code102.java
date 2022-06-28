package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Code102 {

    @Test
    public void test() {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.right = right;

        right.left = new TreeNode(15);
        right.right = new TreeNode(7);
        System.out.println(levelOrder(root));
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        List<TreeNode> rootList = new ArrayList<>();
        rootList.add(root);
        while (rootList.size() != 0) {
            List<Integer> tmpList = new ArrayList<>();
            rootList.forEach(e -> tmpList.add(e.val));
            list.add(tmpList);
            List<TreeNode> level = level(rootList);
            rootList.clear();
            rootList.addAll(level);
        }
        return list;
    }

    public List<TreeNode> level(List<TreeNode> upLevel) {
        List<TreeNode> list = new ArrayList<>();
        upLevel.forEach(e -> {
            if (e.left != null)
                list.add(e.left);
            if (e.right != null)
                list.add(e.right);
        });
        return list;
    }
}
