package book1;

public class Node {

    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        return "Node[" + value + "-left:" + left.value + "-right" + right.value + "]";
    }
}
