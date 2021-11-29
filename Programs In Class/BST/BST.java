package BST;

import java.util.NoSuchElementException;

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
        if (n == null) { // check if tree is empty
            return null;
        } 
        if (data == n.data) { // found it
            return n;
        } else if (data < n.data) { // go left if the data is less than the current node
            return findNode(data, n.left);
        } else { // go right if the data is greater than the current node
            return findNode(data, n.right);
        }
    }

    private Node maxNode(Node n ) {
        assert n != null;
        if (n.right == null) { // if n is the max node return n
            return n;
        } else { // else recurse to the right
            return maxNode(n.right);
        }
    }

    public int max() {
        if (root == null) {
            throw new NoSuchElementException();
        } else {
            return maxNode(root).data;
        }
    }

    private Node minNode(Node n) {
        assert n != null;
        if (n.left == null) { // if n is the min node return n
            return n;
        } else { // else recurse to the left
            return minNode(n.left);
        }
    }

    public int min() {
        if (root == null) {
            throw new NoSuchElementException();
        } else {
            return minNode(root).data;
        }
    }

    public int pred(int data){
        Node n = findNode(data, root);
        if (n == null) {
            throw new NoSuchElementException();
        }
        Node pred = predNode(n);
        if (pred == null) {
            throw new NoSuchElementException();
        }
        return pred.data;
    }

    private Node predNode(Node n) {
        assert n != null;
        if (n.left != null) { // if n has a left child, return the max node of n's left child
            return maxNode(n.left);
        } 
        // move up until there's a right child
        Node p = n.parent;
        while (p != null && n == p.left) {
            n = p;
            p = p.parent;
        }
        return p;
    }

    public void remove(int data) {
        Node n = findNode(data, root);
        if (n != null) {
            removeNode(n);
        }
    }

    private void removeNode(Node n) {
        assert n != null;
        if (n.left == null) {
            replace(n, n.right);
        } else if (n.right == null) {
            replace(n, n.left);
        } else { // 2 children
            Node pred = predNode(n);
            n.data = pred.data;
            removeNode(pred);
        }
    }

    private void replace(Node n, Node child) {
        // replace n with its child in the tree
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
        int[] nums = {17, 5, 92, 50, 8, 23, 14, 37, 75, 9, 13};
        for (int num: nums) {
            t.add(num);
        }
        System.out.println(t);
        System.out.println("Contains 29: " + t.contains(29));
        System.out.println("Contains 14: " + t.contains(14));

        System.out.println("Max: " + t.max());
        System.out.println("Min: " + t.min());

        System.out.println("Pred of 37: " + t.pred(37));
        System.out.println("Pred of 17: " + t.pred(17));
        System.out.println("Pred of 23: " + t.pred(23));
        System.out.println("Pred of 14: " + t.pred(14));
        // System.out.println("Pred of 5: " + t.pred(5));
    }
}
