package BST;

public class BST {
    private Node root;

    private static class Node {
        private int data;
        private Node left, right, parent;
        private Node(int data, Node parent) {
            this.data = data;
            this.parent = parent;
        }
    }

    public void add(int data) {
        if (root == null) {
            root = new Node(data, null);
        } else {
            // call a recursive add
            addNode(data, root);
        }
    }

    private void addNode(int data, Node n) {
        if (data < n.data) {
            if (n.left == null) {
                n.left = new Node(data, n);
            } else {
                addNode(data, n.left);
            }
        } else if (data > n.data) {
            if (n.right == null) {
                n.right = new Node(data, n);
            } else {
                addNode(data, n.right);
            }
        } else {
            // do nothing, ignore duplicates
        }
    }

    public static void main(String[] args) {
        BST t = new BST();
        int[] nums = {17, 5, 92, 50, 8, 23, 14, 37, 75};
        for (int num: nums) {
            t.add(num);
        }
    }
}
