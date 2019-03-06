package code;

import java.util.ArrayList;
import java.util.List;

/**
 * 后序遍历：左子树 ---> 右子树 ---> 根结点
 */
public class postorderTraversal {


    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        if (root != null) {
            tre(root, list);
        }
        return list;
    }

    private void tre(TreeNode root, List<Integer> list) {
        if (root.right != null) {
            tre(root.right, list);
        }
        list.add(root.val);
        if (root.left != null) {
            tre(root.left, list);
        }
    }

}
