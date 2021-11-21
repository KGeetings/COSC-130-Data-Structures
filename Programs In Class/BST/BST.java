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

    public boolean contains (int data) {
        return (findNode(data, root) != null);
    }

    private Node findNode(int data, Node n) {
        if (n == null) {
            return null;
        } if (data == n.data) {
            return n;
        } else if (data < n.data) {
            return findNode(data, n.left);
        } else {
            return findNode(data, n.right);
        }
    }

    @Override
    public String toString() {
        return inorder(root);
    }

    private String inorder(Node n) {
        if (n == null) {
            return "";
        }
        // left, root (node), right
        return inorder(n.left) + n.data + " " + inorder(n.right);
    }

    public static void main(String[] args) {
        BST t = new BST();
        int[] nums = {17, 5, 92, 50, 8, 23, 14, 37, 75};
        for (int num: nums) {
            t.add(num);
        }
        System.out.println(t);
        System.out.println("Contains 29: " + t.contains(29));
        System.out.println("Contains 14: " + t.contains(14));

        BST t2 = new BST();
        int[] nums2 = {24,20,13,5,8,14,23,68,45,27,75,69};
        for (int num: nums2) {
            t2.add(num);
        }
        System.out.println("contains 14: " + t2.contains(14));
        System.out.println("contains 51: " + t2.contains(51));
    }
}
