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
        StringBuffer buffer=new StringBuffer();
        buffer.append("\t").append(value).append("\n")
                .append(left).append("\t").append("\t").append("\t").append(right).append("\n");
        return buffer.toString();
    }
}
