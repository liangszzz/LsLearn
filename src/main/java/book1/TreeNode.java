package book1;

import lombok.Data;

@Data
public class TreeNode {

    int value;
    TreeNode left;
    TreeNode right;

    int balance;

    public TreeNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}
